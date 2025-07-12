package domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class JournalEntry {

    private final String userId;
    private final String journalId;
    private final String prompt;
    private final ArrayList arrayList;
    private final String cleanedOutput;
    private final LocalDateTime createdAt;
    private final Boolean saved;

    public JournalEntry(String journalId, String userId, String starterPrompt, ArrayList<Object> arrayList,
                        String cleanedOutput, LocalDateTime now) {

        this.journalId = journalId;
        // TO-DO: how to generate ids by system?
        // use UUID
        this.userId = userId;
        this.prompt = starterPrompt;
        this.arrayList = arrayList;
        this.cleanedOutput = cleanedOutput;
        this.createdAt = now;

        this.saved = false;

    }

    public String getPrompt() {
        return this.prompt;
    }

    public String getJournalId() {
        return this.journalId;
    }

    public String getCreatedAt() {
        return this.createdAt.toString();
    }

    public String getCleanedOutput() {
        return this.cleanedOutput;
    }
}
