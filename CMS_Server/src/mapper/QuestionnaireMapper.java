package mapper;

import java.util.List;

import entity.Questionnaire;

public interface QuestionnaireMapper {
	public List<Questionnaire> getAllQuestionnaire();
	public Questionnaire getQuestionnaireByName(String questionnaireName);
	public Questionnaire getQuestionnaireByID(int questionnaireID);
	public boolean insertQuestionnaire(Questionnaire questionnaire);
	public boolean deleteQuestionnaire(int questionnaireID);
	public boolean updateQuestionnaire(Questionnaire questionnaire);
}
