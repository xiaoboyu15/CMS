package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Question;
import mapper.QuestionMapper;

@Service
public class QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	
	public List<Question> getAllQuestion(){
		return questionMapper.getAllQuestion();
	}
	public List<Question> getAllQuestionByNaireID(int questionnaireID){
		return questionMapper.getAllQuestionByNaireID(questionnaireID);
	}
	public boolean insertQuestion(Question question) {
		return questionMapper.insertQuestion(question);
	}
	public boolean deleteQuestionByNaireID(int questionnaireID) {
		return questionMapper.deleteQuestionByNaireID(questionnaireID);
	}
}
