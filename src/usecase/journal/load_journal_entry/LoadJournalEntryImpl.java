package usecase.journal.load_journal_entry;

import entity.JournalEntry;
import infrastructure.data_access.JournalDataAccessInterface;

import java.util.Optional;

public class LoadJournalEntryImpl implements LoadJournalEntry {

    private final JournalDataAccessInterface journalDataAccessInterface;

    public LoadJournalEntryImpl(JournalDataAccessInterface repository) {
        this.journalDataAccessInterface = repository;
    }

    @Override
    public Optional<JournalEntry> loadJournalEntry(String journalId) {
        return journalDataAccessInterface.loadById(journalId);
    }
}
