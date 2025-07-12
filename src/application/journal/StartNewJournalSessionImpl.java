package application.journal;

import domain.model.JournalEntry;
import domain.repository.JournalRepository;
import infrastructure.ai.OpenAIGateway;
import usecase.journal.StartNewJournalSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;



public class StartNewJournalSessionImpl implements StartNewJournalSession {
    private final OpenAIGateway ai;
    private final JournalRepository repo;

    public StartNewJournalSessionImpl(OpenAIGateway ai, JournalRepository repo) {
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
