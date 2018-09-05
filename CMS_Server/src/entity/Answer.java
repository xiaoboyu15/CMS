package entity;

public class Answer {
	private int answerID;
	private int questionID;
	private String answerName;
	private int answerTicket;
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getAnswerName() {
		return answerName;
	}
	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}
	public int getAnswerTicket() {
		return answerTicket;
	}
	public void setAnswerTicket(int answerTicket) {
		this.answerTicket = answerTicket;
	}
}
