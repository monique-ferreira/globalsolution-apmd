package globalsolution.apmd.api.repository;

import globalsolution.apmd.api.model.AlertaCritico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaCriticoRepository extends JpaRepository<AlertaCritico, Long> {}
