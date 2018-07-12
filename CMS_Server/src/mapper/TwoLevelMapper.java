package mapper;

import java.util.List;

import entity.TwoLevel;

public interface TwoLevelMapper {
	public List<TwoLevel> getTwoByOne(int oneLevelID);

	public List<TwoLevel> getAllTwo();

	public TwoLevel getOnlyTwo(String twoLevelName);

	public boolean insertTwo(TwoLevel twoLevel);

	public boolean deleteTwo(String twoLevelName);

	public boolean deleteTwoByOne(int oneLevelID);

	public boolean updateTwo(TwoLevel twoLevel);
}
