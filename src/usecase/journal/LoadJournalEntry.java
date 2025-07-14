package usecase.journal;

import domain.model.JournalEntry;

import java.util.Optional;

public interface LoadJournalEntry {
    Optional<JournalEntry> loadJournalEntry(String journalId);
}
