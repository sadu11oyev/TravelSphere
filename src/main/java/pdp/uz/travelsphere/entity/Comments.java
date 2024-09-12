package pdp.uz.travelsphere.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments extends BaseEntity {
    private String comment;

    @ManyToOne
    private User user;

}
