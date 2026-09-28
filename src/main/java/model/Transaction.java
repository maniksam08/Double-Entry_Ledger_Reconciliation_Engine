package model;

import enums.TransactionStatus;
import enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private UUID transactionId;

    @Column(unique = true, nullable = false)
    private String referenceId;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @CreationTimestamp
    public LocalDateTime created_at;
}
