package infrastructure.gateway;

import java.util.List;

public class DummyOpenAIGateway implements OpenAIGateway {
    @Override
    public String generateStarterPrompt() {
        return "What is something you want to share about today?";
    }

    // not yet used because no api call yet. currently using mock version in generatefollowwupimpl.java
    @Override
    public String generateFollowUp(String userMessage) {
        return "Did that affect your feeling or thoughts?";
    }

    @Override
    public String cleanUpJournal(List<String> messages) {
        return "this is a dummy journal";
    }
}
