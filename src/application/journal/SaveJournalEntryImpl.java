package application.journal;

import domain.model.JournalEntry;
import domain.repository.JournalRepository;
import infrastructure.repository.InMemoryJournalRepository;
import usecase.journal.SaveJournalEntry;

public class SaveJournalEntryImpl implements SaveJournalEntry {

    private final JournalRepository journalRepository;

    public SaveJournalEntryImpl(JournalRepository repository) {
        this.journalRepository = repository;
    }

    @Override
    public void saveJournalEntry(JournalEntry journalEntry) {
        journalRepository.save(journalEntry);
    }
}
