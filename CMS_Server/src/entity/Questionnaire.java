package entity;

import java.util.ArrayList;

public class Questionnaire {
	private int questionnaireID;
	private String questionnaireName;
	private ArrayList<String> QA;
	private int childID;
	public int getChildID() {
		return childID;
	}
	public void setChildID(int childID) {
		this.childID = childID;
	}
	public int getQuestionnaireID() {
		return questionnaireID;
	}
	public void setQuestionnaireID(int questionnaireID) {
		this.questionnaireID = questionnaireID;
	}
	public String getQuestionnaireName() {
		return questionnaireName;
	}
	public void setQuestionnaireName(String questionnaireName) {
		this.questionnaireName = questionnaireName;
	}

	public ArrayList<String> getQA() {
		return QA;
	}
	public void setQA(ArrayList<String> qA) {
		QA = qA;
	}
	
}
