public class Question {
    private int id;
    private String text;
    private String[] options = new String[4];
    private int correctOption;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String[] getOptions() { return options; }
    public void setOptions(String[] options) { this.options = options; }
    public int getCorrectOption() { return correctOption; }
    public void setCorrectOption(int correctOption) { this.correctOption = correctOption; }
}
