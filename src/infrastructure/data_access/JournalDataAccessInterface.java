package infrastructure.data_access;

import entity.JournalEntry;
import java.util.Optional;
// had to import these because of packaging?

public interface JournalDataAccessInterface {
    void save(JournalEntry entry);
    Optional<JournalEntry> loadById(String journalId);
}
