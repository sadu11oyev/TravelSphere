package pdp.uz.travelsphere.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.travelsphere.entity.Country;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
}