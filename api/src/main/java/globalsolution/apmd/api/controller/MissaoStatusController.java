package globalsolution.apmd.api.controller;

import globalsolution.apmd.api.dto.MissaoStatusDTO;
import globalsolution.apmd.api.model.AlertaCritico;
import globalsolution.apmd.api.model.EventoOperacional;
import globalsolution.apmd.api.model.Sensor;
import globalsolution.apmd.api.service.AlertaCriticoService;
import globalsolution.apmd.api.service.EventoOperacionalService;
import globalsolution.apmd.api.service.SensorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class MissaoStatusController {

    private final SensorService sensorService;
    private final EventoOperacionalService eventoService;
    private final AlertaCriticoService alertaService;

    public MissaoStatusController(SensorService sensorService,
                                   EventoOperacionalService eventoService,
                                   AlertaCriticoService alertaService) {
        this.sensorService = sensorService;
        this.eventoService = eventoService;
        this.alertaService = alertaService;
    }

    @GetMapping
    public MissaoStatusDTO status() {
        List<Sensor> sensores = sensorService.listar();
        List<EventoOperacional> eventos = eventoService.listar();
        List<AlertaCritico> alertas = alertaService.listar();

        long sensoresAtivos = sensores.stream()
                .filter(s -> Boolean.TRUE.equals(s.getAtivo())).count();

        long eventosAbertos = eventos.stream()
                .filter(e -> !"CONCLUIDO".equalsIgnoreCase(e.getStatus())).count();

        long alertasCriticos = alertas.stream()
                .filter(a -> !Boolean.TRUE.equals(a.getResolvido())
                        && "CRITICO".equalsIgnoreCase(a.getNivel())).count();

        long alertasAbertos = alertas.stream()
                .filter(a -> !Boolean.TRUE.equals(a.getResolvido())).count();

        int saude = 100;
        if (!sensores.isEmpty()) {
            long inativos = sensores.size() - sensoresAtivos;
            saude -= (int) (inativos * 8);
        }
        saude -= (int) (alertasCriticos * 12);
        saude -= (int) (Math.min(alertasAbertos - alertasCriticos, 5) * 3);
        saude = Math.max(0, Math.min(100, saude));

        return new MissaoStatusDTO(
                sensores.size(), sensoresAtivos,
                eventos.size(), eventosAbertos,
                alertas.size(), alertasCriticos,
                alertasAbertos, saude
        );
    }
}
