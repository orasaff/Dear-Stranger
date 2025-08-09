package infrastructure.gateway;

import java.util.List;

public interface OpenAIGateway {

    String generateStarterPrompt();
    String generateFollowUp(String userMessage);
    String cleanUpJournal(List<String> messages);

}
