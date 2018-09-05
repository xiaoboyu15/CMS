package mapper;

import java.util.List;

import entity.Question;

public interface QuestionMapper {
	public List<Question> getAllQuestion();
	public List<Question> getAllQuestionByNaireID(int questionnaireID);
	public boolean insertQuestion(Question question);
	public boolean deleteQuestionByNaireID(int questionnaireID);
}
