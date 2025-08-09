package usecase.journal.load_journal_entry;

import entity.JournalEntry;

import java.util.Optional;

public interface LoadJournalEntry {
    Optional<JournalEntry> loadJournalEntry(String journalId);
}
