package entity;

import java.util.List;

public class OneLevel {
	private int oneLevelID;
	private String oneLevelName;
	private List<String> twoLevelNames;
	private List<TwoLevel> twoLevels;
	

	public List<TwoLevel> getTwoLevels() {
		return twoLevels;
	}

	public void setTwoLevels(List<TwoLevel> twoLevels) {
		this.twoLevels = twoLevels;
	}

	public String getOneLevelName() {
		return oneLevelName;
	}

	public List<String> getTwoLevelNames() {
		return twoLevelNames;
	}

	public void setTwoLevelNames(List<String> twoLevelNames) {
		this.twoLevelNames = twoLevelNames;
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

}
