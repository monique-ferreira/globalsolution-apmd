package globalsolution.apmd.api.controller;

import globalsolution.apmd.api.model.EventoOperacional;
import globalsolution.apmd.api.service.EventoOperacionalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoOperacionalController {
    private final EventoOperacionalService service;

    public EventoOperacionalController(EventoOperacionalService service) {
        this.service = service;
    }

    @GetMapping
    public List<EventoOperacional> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public EventoOperacional buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public EventoOperacional salvar(@RequestBody EventoOperacional evento) {
        return service.salvar(evento);
    }

    @PutMapping("/{id}")
    public EventoOperacional atualizar(@PathVariable Long id, @RequestBody EventoOperacional evento) {
        return service.atualizar(id, evento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
