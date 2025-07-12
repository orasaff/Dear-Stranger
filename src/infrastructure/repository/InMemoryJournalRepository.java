package infrastructure.repository;

import domain.model.JournalEntry;
import domain.repository.JournalRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryJournalRepository implements JournalRepository {
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
