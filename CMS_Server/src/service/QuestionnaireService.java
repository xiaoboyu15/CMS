package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Questionnaire;
import mapper.QuestionnaireMapper;

@Service
public class QuestionnaireService {
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	
	//获取所有问卷   父
	public List<Questionnaire> getAllQuestionnaire(){
		return questionnaireMapper.getAllQuestionnaire();
	}
	public Questionnaire getQuestionnaireByName(String questionnaireName) {
		return questionnaireMapper.getQuestionnaireByName(questionnaireName);
	}
	//根据ID获取问卷  父
	public Questionnaire getQuestionnaireByID(int questionnaireID) {
		return questionnaireMapper.getQuestionnaireByID(questionnaireID);
	}
	//插入父表与子表关系以及所需数据
	public boolean insertQuestionnaire(Questionnaire questionnaire) {
		return questionnaireMapper.insertQuestionnaire(questionnaire);
	}
	//删除父表数据
	public boolean deleteQuestionnaire(int questionnaireID) {
		return questionnaireMapper.deleteQuestionnaire(questionnaireID);
	}
	//动态创建子表
	public boolean updateQuestionnaire(Questionnaire questionnaire) {
		return questionnaireMapper.updateQuestionnaire(questionnaire);
	}
	
}
