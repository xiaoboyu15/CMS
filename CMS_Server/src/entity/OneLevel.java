package entity;

public class OneLevel {
	private int oneLevelID;
	private String oneLevelName;
	private int twoLevelID;
	public String getOneLevelName() {
		return oneLevelName;
	}
	public int getOneLevelID() {
		return oneLevelID;
	}
	public void setOneLevelID(int oneLevelID) {
		this.oneLevelID = oneLevelID;
	}
	public void setOneLevelName(String oneLevelName) {
		this.oneLevelName = oneLevelName;
	}
	public int getTwoLevelID() {
		return twoLevelID;
	}
	public void setTwoLevelID(int twoLevelID) {
		this.twoLevelID = twoLevelID;
	}
}
