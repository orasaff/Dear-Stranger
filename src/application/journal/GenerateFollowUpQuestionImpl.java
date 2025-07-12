package application.journal;

import usecase.journal.GenerateFollowUpQuestion;
import java.util.Random;

public class GenerateFollowUpQuestionImpl implements GenerateFollowUpQuestion {

    private static final String[] QUESTIONS = {
            "What was going through your mind at the time?",
            "Can you tell me more about that?",
            "What part stood out to you the most?",
            "Do you think this ties into something deeper you’ve been feeling lately?"
    };

    private final Random random = new Random();

    @Override
    public String generateFollowUpQuestion(String context) {
        int index = random.nextInt(QUESTIONS.length);
        return QUESTIONS[index];
    }
}
