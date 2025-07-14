package usecase.journal;

import domain.model.JournalEntry;

public interface CleanUpJournalOutput {
    String cleanUpJournalOutput(JournalEntry journal);
}