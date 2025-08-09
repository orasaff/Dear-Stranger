package usecase.journal.save_journal_entry;

import entity.JournalEntry;

public interface SaveJournalEntry {
    void saveJournalEntry(JournalEntry journalEntry);
}
