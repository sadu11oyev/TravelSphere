package pdp.uz.travelsphere.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.travelsphere.entity.enums.Rate;

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

    @Enumerated(EnumType.STRING)
    private Rate rate;
}
