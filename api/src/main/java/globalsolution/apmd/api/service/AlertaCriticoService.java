package globalsolution.apmd.api.service;

import globalsolution.apmd.api.model.AlertaCritico;
import globalsolution.apmd.api.repository.AlertaCriticoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertaCriticoService {
    private final AlertaCriticoRepository repository;

    public AlertaCriticoService(AlertaCriticoRepository repository) {
        this.repository = repository;
    }

    public List<AlertaCritico> listar() {
        return repository.findAll();
    }

    public AlertaCritico buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Alerta não encontrado: " + id));
    }

    public AlertaCritico salvar(AlertaCritico alerta) {
        return repository.save(alerta);
    }

    public AlertaCritico atualizar(Long id, AlertaCritico alerta) {
        AlertaCritico existente = buscarPorId(id);
        existente.setTitulo(alerta.getTitulo());
        existente.setDescricao(alerta.getDescricao());
        existente.setNivel(alerta.getNivel());
        existente.setDataHora(alerta.getDataHora());
        existente.setResolvido(alerta.getResolvido());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
