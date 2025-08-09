package entity;

public class QAEntry {
    private String question;
    private String response;

    public QAEntry(String question, String response) {
        this.question = question;
        this.response = response;
    }

    public String getQuestion() {
        return question;
    }

    public String getResponse() {
        return response;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setResponse(String response) {this.response = response;}

    public String getQuestionInResponseForm() {
        // If question is asking user for What... then we make a cut-out form.
        if (this.isWhatQuestion()) {
            // withOutWhat is a string that starts with the next word than "What" in question
            String withOutWhat = question.substring(5);

            String result = withOutWhat;
            // Change "your" to "my" and "you" to "I".
            if (withOutWhat.contains("your")) {
                result = withOutWhat.replace( "your", "my");
            }
            else if (withOutWhat.contains("to you")) {
                result = withOutWhat.replace( "to you", "to me");
            }
            else if (withOutWhat.contains("that you")) {
                result = withOutWhat.replace( "that you", "that I");
            }

            // Replace the question mark at the end with a period.

            return result.replace("?", "");
        }

        return null;
    }

    public boolean isWhatQuestion() {
        return this.question.startsWith("What");
    }
}
