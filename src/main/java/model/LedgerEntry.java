package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "ledger_entries")
@Data
public class LedgerEntry {

    @Id
    @GeneratedValue
    private UUID LedgerId;

    @ManyToOne(optional = false)
    @JoinColumn(name= "transaction_id")
    @ToString.Exclude
    private Transaction transaction;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    private Account account;

    @Column(nullable = false)
    private BigDecimal amount;

    @CreationTimestamp
    private LocalDateTime loggedAt;

    @Column(nullable = false)
    private String hash;

    @Column( name = "previous_hash")
    private  String prevHash;
}
