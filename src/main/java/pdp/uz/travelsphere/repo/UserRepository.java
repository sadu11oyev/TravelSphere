package pdp.uz.travelsphere.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pdp.uz.travelsphere.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(nativeQuery = true, value = "select * from users where phone=:phone")
    User findByUsername(String phone);
}