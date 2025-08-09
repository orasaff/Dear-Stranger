package usecase.journal.save_journal_entry;

import entity.JournalEntry;
import infrastructure.data_access.JournalDataAccessInterface;

public class SaveJournalEntryImpl implements SaveJournalEntry {

    private final JournalDataAccessInterface journalDataAccessInterface;

    public SaveJournalEntryImpl(JournalDataAccessInterface repository) {
        this.journalDataAccessInterface = repository;
    }

    @Override
    public void saveJournalEntry(JournalEntry journalEntry) {
        journalDataAccessInterface.save(journalEntry);
    }
}
