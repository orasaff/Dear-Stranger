package usecase.journal;

import domain.model.JournalEntry;

/**
 * Use Case: Start a new journal session for a user.
 * Responsibilities:
 * - Generate a starter AI prompt
 * - Create and return a new JournalEntry
 * - Persist the new journal using the repository
 */
public interface StartNewJournalSession {
    /**
     * Starts a new journaling session by generating an AI prompt
     * and creating a new JournalEntry for the given user.
     *
     * @param userId The ID of the user starting the journal
     * @return The new JournalEntry with a generated prompt
     */
    JournalEntry startNewJournalSession(String userId);
}
