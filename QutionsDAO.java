import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    public List<Question> getQuestionsByQuizId(int quizId) {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM questions WHERE quiz_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, quizId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("question_id"));
                question.setText(rs.getString("question_text"));
                question.setOptions(new String[]{
                    rs.getString("option_1"),
                    rs.getString("option_2"),
                    rs.getString("option_3"),
                    rs.getString("option_4")
                });
                question.setCorrectOption(rs.getInt("correct_option"));
                questions.add(question);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
}
