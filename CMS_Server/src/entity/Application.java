package entity;

public class Application {
	private int applicationID;
	private String applicationName;
	private String nowPower;
	private String applicationPower;
	private String applicationDate;
	private int applicationState;
	private String why;
	private int personID;
	public String getNowPower() {
		return nowPower;
	}
	public void setNowPower(String nowPower) {
		this.nowPower = nowPower;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getWhy() {
		return why;
	}
	public void setWhy(String why) {
		this.why = why;
	}
	public String getApplicationPower() {
		return applicationPower;
	}
	public void setApplicationPower(String applicationPower) {
		this.applicationPower = applicationPower;
	}
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public int getApplicationState() {
		return applicationState;
	}
	public void setApplicationState(int applicationState) {
		this.applicationState = applicationState;
	}
}
