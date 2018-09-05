package mapper;

import java.util.List;

import entity.Answer;

public interface AnswerMapper {
	
	public List<Answer> getAllAnswer();
	public List<Answer> getAllAnswerByQuestionID(int questionID);
	public boolean insertAnswer(Answer answer);
	public boolean deleteAnswerByQuestionID(int questionID);

}
