package Repositary;

import model.Account;
import model.LedgerEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntry, UUID> {
    List<LedgerEntry> findByAccount_AccountIdOrderByLoggedAtAsc(UUID accountId);
    Optional<LedgerEntry> findTopByAccountOrderByLoggedAtDesc(Account account);
    Page<LedgerEntry> findLedgerEntryByAccount_AccountId(UUID accountId, Pageable pageable);

}
