package domain.repository;

import domain.model.JournalEntry;
import java.util.Optional;
// had to import these because of packaging?

public interface JournalRepository {
    void save(JournalEntry entry);
    Optional<JournalEntry> loadById(String journalId);
}
