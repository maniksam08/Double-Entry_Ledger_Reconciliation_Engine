package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDTO {

    @NotBlank
    @Size(min = 1, max = 50)
    private String accountName;

    @NotNull
    @Pattern(regexp = "[A-Z]{3}$", message = "It should be a valid 3 character currency symbol")
    private String currency;
}
