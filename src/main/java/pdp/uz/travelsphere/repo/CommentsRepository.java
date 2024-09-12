package pdp.uz.travelsphere.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.travelsphere.entity.Comments;

import java.util.UUID;

public interface CommentsRepository extends JpaRepository<Comments, UUID> {
}