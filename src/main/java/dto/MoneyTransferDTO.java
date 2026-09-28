package dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferDTO {

    @NotNull
    private UUID toAccountId;

    @NotNull
    private UUID fromAccountId;

    @NotNull
    private String referenceId;

    @NotNull
    private BigDecimal amount;

}
