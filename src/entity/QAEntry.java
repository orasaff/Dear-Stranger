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
}
