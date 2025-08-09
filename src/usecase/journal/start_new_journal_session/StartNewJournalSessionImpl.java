package usecase.journal.start_new_journal_session;

import entity.JournalEntry;
import infrastructure.data_access.JournalDataAccessInterface;
import infrastructure.gateway.OpenAIGateway;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;



public class StartNewJournalSessionImpl implements StartNewJournalSession {
    private final OpenAIGateway ai;
    private final JournalDataAccessInterface repo;

    public StartNewJournalSessionImpl(OpenAIGateway ai, JournalDataAccessInterface repo) {
        this.ai = ai;
        this.repo = repo;
    }

    @Override
    public JournalEntry startNewJournalSession(String userId) {
        String prompt = ai.generateStarterPrompt();  // Hardcoded for now

        JournalEntry entry = new JournalEntry(
                UUID.randomUUID().toString(),
                userId,
                prompt,
                new ArrayList<>(),
                "", // cleanedOutput (empty for now)
                LocalDateTime.now()
        );

        repo.save(entry);
        return entry;
    }
}
