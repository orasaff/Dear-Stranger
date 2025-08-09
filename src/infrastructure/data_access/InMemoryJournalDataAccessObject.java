package infrastructure.data_access;

import entity.JournalEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryJournalDataAccessObject implements JournalDataAccessInterface {
    private final Map<String, JournalEntry> storage = new HashMap<>();

    @Override
    public void save(JournalEntry entry) {
        storage.put(entry.getJournalId(), entry);
    }

    @Override
    public Optional<JournalEntry> loadById(String journalId) {
        return Optional.ofNullable(storage.get(journalId));
    }
}
