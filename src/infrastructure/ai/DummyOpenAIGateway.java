package infrastructure.ai;

import java.util.List;

public class DummyOpenAIGateway implements OpenAIGateway {
    @Override
    public String generateStarterPrompt() {
        return "What’s something small that made you smile today?";
    }

    @Override
    public String generateFollowUp(String userMessage) {
        return "Did that affect your feeling or thoughts?";
    }

    @Override
    public String cleanUpJournal(List<String> messages) {
        return "this is a dummy journal";
    }
}
