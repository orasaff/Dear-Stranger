package application.journal;

import domain.model.JournalEntry;
import domain.model.QAEntry;
import usecase.journal.CleanUpJournalOutput;

public class CleanUpJournalOutputImpl implements CleanUpJournalOutput {

    /**
     * Clean up conversational data into writeen journal format.
     * @param journal - raw journal that need cleaning.
     * @return cleaned journal output
     */
    @Override
    public String cleanUpJournalOutput(JournalEntry journal) {
        StringBuilder sb = new StringBuilder();
        String cleaned = "";
        for (QAEntry qaEntry : journal.getQaEntries()) {
            cleaned = punctuate(qaEntry.getQuestion(), qaEntry.getResponse());
            sb.append(cleaned).append(" ");
        }
        return sb.toString().trim();
    }

    /**
    * Capitalizing First Letter and Adding End-of-sentence Punctuation.
    * @param question - question given by system
    * @ param response - answer by user
    * @return String of cleaned output
     */
    private String punctuate(String question, String response) {

        response = response.trim(); // get rid of unnecessary space

        //Capitalize
        if (!response.isEmpty()) {
            response = response.substring(0, 1).toUpperCase() + response.substring(1);
        }
        if (!response.endsWith(".") && !response.endsWith("!") && !response.endsWith("?")) {
            response += ".";
        }
        return response;
    }
}
