package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.QA;
import mapper.QAMapper;

@Service
public class QAService {
	@Autowired
	private QAMapper qaMapper;
	public List<QA> getAllQA(){
		return qaMapper.getAllQA();
	}
	
	public boolean insertQuestion(QA qa) {
		return qaMapper.insertQuestion(qa);
	}

}
