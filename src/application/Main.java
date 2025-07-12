package application;

import application.journal.StartNewJournalSessionImpl;
import domain.model.JournalEntry;
import infrastructure.ai.DummyOpenAIGateway;
import infrastructure.repository.InMemoryJournalRepository;
import usecase.journal.StartNewJournalSession;

public class Main {
    public static void main(String[] args) {
        StartNewJournalSession useCase = new StartNewJournalSessionImpl(
                new DummyOpenAIGateway(),
                new InMemoryJournalRepository()
        );
        JournalEntry result = useCase.startNewJournalSession("user1");

        System.out.println("Prompt: " + result.getCurrentPrompt());
        System.out.println("Time: " + result.getCreatedAt());
        System.out.println("Journal ID: " + result.getJournalId());
    }
}

