package globalsolution.apmd.api.service;

import globalsolution.apmd.api.model.Sensor;
import globalsolution.apmd.api.repository.SensorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorService {
    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public List<Sensor> listar() {
        return repository.findAll();
    }

    public Sensor buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Sensor não encontrado: " + id));
    }

    public Sensor salvar(Sensor sensor) {
        return repository.save(sensor);
    }

    public Sensor atualizar(Long id, Sensor sensor) {
        Sensor existente = buscarPorId(id);
        existente.setNome(sensor.getNome());
        existente.setTipo(sensor.getTipo());
        existente.setStatus(sensor.getStatus());
        existente.setLeituraAtual(sensor.getLeituraAtual());
        existente.setUnidade(sensor.getUnidade());
        existente.setAtivo(sensor.getAtivo());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
