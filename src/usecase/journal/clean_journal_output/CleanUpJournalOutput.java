package usecase.journal.clean_journal_output;

import entity.JournalEntry;

public interface CleanUpJournalOutput {
    String cleanUpJournalOutput(JournalEntry journal);
}