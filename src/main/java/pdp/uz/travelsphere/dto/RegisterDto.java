package pdp.uz.travelsphere.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link pdp.uz.travelsphere.entity.User}
 */
public record RegisterDto(@NotEmpty @NotNull String firstName,
                          @NotEmpty @NotNull String lastName,
                          @NotEmpty @NotNull String phone,
                          @NotNull @NotEmpty String password) implements Serializable {
}
