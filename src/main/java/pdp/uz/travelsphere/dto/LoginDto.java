package pdp.uz.travelsphere.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for Login{@link pdp.uz.travelsphere.entity.User}
 */
public record LoginDto (@NotNull @NotEmpty String username,
                        @NotNull @NotEmpty String password)implements Serializable {
}
