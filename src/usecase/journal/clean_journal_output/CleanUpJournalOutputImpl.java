package usecase.journal.clean_journal_output;

import entity.JournalEntry;
import entity.QAEntry;

public class CleanUpJournalOutputImpl implements CleanUpJournalOutput {

    /**
     * Clean up conversational data into writeen journal format.
     * @param journal - raw journal that need cleaning.
     * @return cleaned journal output
     */
    @Override
    public String cleanUpJournalOutput(JournalEntry journal) {
        StringBuilder sb = new StringBuilder();
        for (QAEntry qaEntry : journal.getQaEntries()) {
            // Get rid of unnecessary space;
            String response = qaEntry.getResponse().trim();

            // If the response is a single word, maybe user was answering something.
            if (!response.contains(" ")) {
                // Here, cleaned is a single word response.
                
                // Rephrase single word response for "What" questions
                if (qaEntry.isWhatQuestion()) {
                    response = rephraseResponseToWhatQuestion(qaEntry, response);
                }
            }

            // Correct capitalization and punctuation for response.
            String cleaned = punctuate(response);
            // Add this response to the String of all response unless its empty.
            if (!cleaned.isEmpty()) {
                sb.append(cleaned).append(" ");
            }
        }
        // Return result with unnecessary space at the end gone.
        return sb.toString().trim();
    }

    private String rephraseResponseToWhatQuestion(QAEntry qaEntry, String response) {
        StringBuilder word = new StringBuilder();
        StringBuilder punctuation = new StringBuilder();

        // Move away the punctuation after the word.
        for (int i = 0; i < response.length(); i++) {
            // check if c is a punctuation
            if (isPunctuation(response.charAt(i))) {
                punctuation.append(response.charAt(i));
            }
            else {
                word.append(response.charAt(i));
            }
        }
        // combine the new response.
        response = word + " " + qaEntry.getQuestionInResponseForm() + punctuation;
        return response;
    }

    /**
    * Capitalizing First Letter and Adding End-of-sentence Punctuation.
     *
     * @ param response - answer by user
     * @return String of cleaned output
     */
    private String punctuate(String response) {

        // punctuate non-empty response
        if (!response.isEmpty()) {
            // Capitalize first letter of the response.
            response = response.substring(0, 1).toUpperCase() + response.substring(1);

            // Add punctuation at the end of response.
            if (!response.endsWith(".") && !response.endsWith(",") && !response.endsWith("!") && !response.endsWith("?")) {
                response += ".";
            }
        }

        return response;
    }

    private boolean isPunctuation(char c) {
        return (c == '.' || c == ',' || c == '?' || c == '!');
    }
}
