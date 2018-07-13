package mapper;

import java.util.List;

import entity.Questionnaire;

public interface QuestionnaireMapper {
	public List<Questionnaire> getAllQuestionnaire();
	public Questionnaire getQuestionnaireByID(int questionnaireID);
	public boolean insertQuestionnaire(Questionnaire questionnaire);
	public boolean insertChild(Questionnaire questionnaire);
	public boolean deleteQuestionnaire(int questionnaireID);
	public boolean deleteQuestionnaireChild(Questionnaire questionnaireName);
	public boolean updateQuestionnaire(Questionnaire questionnaire);
}
