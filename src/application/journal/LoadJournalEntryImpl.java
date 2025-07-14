package application.journal;

import domain.model.JournalEntry;
import domain.repository.JournalRepository;
import usecase.journal.LoadJournalEntry;
import java.util.Optional;

public class LoadJournalEntryImpl implements LoadJournalEntry {

    private final JournalRepository journalRepository;

    public LoadJournalEntryImpl(JournalRepository repository) {
        this.journalRepository = repository;
    }

    @Override
    public Optional<JournalEntry> loadJournalEntry(String journalId) {
        return journalRepository.loadById(journalId);
    }
}
