package usecase.journal.generate_follow_up_question;

import java.util.Random;

public class GenerateFollowUpQuestionImpl implements GenerateFollowUpQuestion {

    private static final String[] QUESTIONS = {
            "What was going through your mind at the time?",
            "What stood out to you the most about that?",
            "What is that you really care about?",
            "Can you tell me more about that?",
            "I'm interested, what's more?",
            "Keep talking, I'm listening!"
    };

    private final Random random = new Random();

    @Override
    public String generateFollowUpQuestion(String context) {
        // mock version
        int index = random.nextInt(QUESTIONS.length);
        return QUESTIONS[index];
    }
}
