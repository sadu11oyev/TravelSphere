package pdp.uz.travelsphere.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record ChangePasswordDto(@NotNull @NotEmpty String username,
                                @NotNull @NotEmpty String oldPassword,
                                @NotNull @NotEmpty String newPassword)implements Serializable {
}
