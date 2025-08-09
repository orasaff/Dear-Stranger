package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JournalEntry {

    private final String userId;
    private final String journalId;
    private final String prompt;
    private List<QAEntry> qaEntries;
    private String cleanedOutput;
    private final LocalDateTime createdAt;
    private final Boolean saved;

    public JournalEntry(String journalId, String userId, String starterPrompt, List<QAEntry> qaEntries,
                        String cleanedOutput, LocalDateTime now) {

        this.journalId = journalId;
        this.userId = userId;
        this.prompt = starterPrompt;
        this.qaEntries = qaEntries;
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

    public List<QAEntry> getQaEntries() {
        return this.qaEntries;
    }

    public void addQaEntries(String question , String response) {
        if (qaEntries == null) {
            this.qaEntries = new ArrayList<>();
        }
        this.qaEntries.add(new QAEntry(question, response));
    }

    public void setCleanedOutput(String join) {
        this.cleanedOutput = join;
    }
}
