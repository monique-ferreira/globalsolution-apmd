package globalsolution.apmd.api.controller;

import globalsolution.apmd.api.model.AlertaCritico;
import globalsolution.apmd.api.service.AlertaCriticoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaCriticoController {
    private final AlertaCriticoService service;

    public AlertaCriticoController(AlertaCriticoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AlertaCritico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public AlertaCritico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public AlertaCritico salvar(@RequestBody AlertaCritico alerta) {
        return service.salvar(alerta);
    }

    @PutMapping("/{id}")
    public AlertaCritico atualizar(@PathVariable Long id, @RequestBody AlertaCritico alerta) {
        return service.atualizar(id, alerta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
