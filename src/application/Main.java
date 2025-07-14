package application;

import application.journal.*;
import domain.model.JournalEntry;
import domain.model.QAEntry;
import domain.repository.JournalRepository;
import infrastructure.ai.DummyOpenAIGateway;
import infrastructure.ai.OpenAIGateway;
import infrastructure.repository.InMemoryJournalRepository;
import usecase.journal.*;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Set up
        OpenAIGateway gateway = new DummyOpenAIGateway();
        JournalRepository repo = new InMemoryJournalRepository();

        // Start new journal session (use case 01)
        StartNewJournalSession useCase = new StartNewJournalSessionImpl(
                gateway,
                repo
        );
        JournalEntry journal = useCase.startNewJournalSession("user1");

        System.out.println("Time: " + journal.getCreatedAt());
        System.out.println("Journal ID: " + journal.getJournalId());
        System.out.println("Starting a new journal session...\n");

        Scanner scanner = new Scanner(System.in);

        // Ask the Starting question (Prompt)
        String question = journal.getPrompt();
        System.out.println(question);
        String response = scanner.nextLine();

        GenerateFollowUpQuestion generate = new GenerateFollowUpQuestionImpl();

        while (true) {
            if (response.equalsIgnoreCase("exit")) {
                break;
            }
            else {
                journal.addQaEntries(question, response);

                // generate followup question (use case 02)
                question = generate.generateFollowUpQuestion(response);
                System.out.println(question);
                response = scanner.nextLine();
            }
        }

        System.out.println("Ending a new journal session...\n");

        // use case 05 - cleaning into written journal
        CleanUpJournalOutput cleanUp = new CleanUpJournalOutputImpl();
        String cleaned = cleanUp.cleanUpJournalOutput(journal);
        journal.setCleanedOutput(cleaned);


        // use case 03 - saving
        SaveJournalEntry saveUseCase = new SaveJournalEntryImpl(repo);
        saveUseCase.saveJournalEntry(journal);
        System.out.println("Journal saved successfully!");

        // use case 04 - loading
        LoadJournalEntry loadUseCase = new LoadJournalEntryImpl(repo);
        Optional<JournalEntry> loaded = loadUseCase.loadJournalEntry(journal.getJournalId());

        if (loaded.isPresent()) {
            System.out.println("Journal loaded successfully!");
            JournalEntry loadedJournal = loaded.get();
            System.out.println("Loaded Cleaned Output:");
            System.out.println(loadedJournal.getCleanedOutput());  // or getResponses()
        } else {
            System.out.println("Journal could not be found.");
        }



    }


}

