package pdp.uz.travelsphere.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Demand extends BaseEntity{

    @ManyToOne
    private Country country;

    @ManyToOne
    private User user;

    private String rate;
}
