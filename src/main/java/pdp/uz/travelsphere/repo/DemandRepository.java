package pdp.uz.travelsphere.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.travelsphere.entity.Demand;

import java.util.UUID;

public interface DemandRepository extends JpaRepository<Demand, UUID> {
}