package pdp.uz.travelsphere.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.travelsphere.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}