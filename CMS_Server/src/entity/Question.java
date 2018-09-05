package entity;

public class Question {
	private int questionID;
	private String questionName;
	private int questionnaireID;
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public int getQuestionnaireID() {
		return questionnaireID;
	}
	public void setQuestionnaireID(int questionnaireID) {
		this.questionnaireID = questionnaireID;
	}
}
