package usecase.journal;

import domain.model.JournalEntry;

public interface SaveJournalEntry {
    void saveJournalEntry(JournalEntry journalEntry);
}
