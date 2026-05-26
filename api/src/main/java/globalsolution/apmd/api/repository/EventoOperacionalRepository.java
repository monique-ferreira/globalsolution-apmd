package globalsolution.apmd.api.repository;

import globalsolution.apmd.api.model.EventoOperacional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoOperacionalRepository extends JpaRepository<EventoOperacional, Long> {}
