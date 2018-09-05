package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Answer;
import mapper.AnswerMapper;

@Service
public class AnswerService {
	@Autowired
	private AnswerMapper answerMapper;
	
	public List<Answer> getAllAnswer(){
		return answerMapper.getAllAnswer();
	}
	public List<Answer> getAllAnswerByQuestionID(int questionID){
		return answerMapper.getAllAnswerByQuestionID(questionID);
	}
	public boolean insertAnswer(Answer answer) {
		return answerMapper.insertAnswer(answer);
	}
	public boolean deleteAnswerByQuestionID(int questionID) {
		return answerMapper.deleteAnswerByQuestionID(questionID);
	}
}
