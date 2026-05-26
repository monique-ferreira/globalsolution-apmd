package globalsolution.apmd.api.service;

import globalsolution.apmd.api.model.EventoOperacional;
import globalsolution.apmd.api.repository.EventoOperacionalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoOperacionalService {
    private final EventoOperacionalRepository repository;

    public EventoOperacionalService(EventoOperacionalRepository repository) {
        this.repository = repository;
    }

    public List<EventoOperacional> listar() {
        return repository.findAll();
    }

    public EventoOperacional buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado: " + id));
    }

    public EventoOperacional salvar(EventoOperacional evento) {
        return repository.save(evento);
    }

    public EventoOperacional atualizar(Long id, EventoOperacional evento) {
        EventoOperacional existente = buscarPorId(id);
        existente.setDescricao(evento.getDescricao());
        existente.setSistema(evento.getSistema());
        existente.setDataHora(evento.getDataHora());
        existente.setTipo(evento.getTipo());
        existente.setStatus(evento.getStatus());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
