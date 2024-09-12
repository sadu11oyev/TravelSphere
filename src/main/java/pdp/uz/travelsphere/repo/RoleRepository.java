package pdp.uz.travelsphere.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.travelsphere.entity.Role;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}