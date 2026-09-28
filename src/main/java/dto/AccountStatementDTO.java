package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountStatementDTO {
    private LocalDateTime date;
    private BigDecimal balance;
    private String referenceId;
    private String type;
}
