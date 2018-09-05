package mapper;

import java.util.List;

import entity.OneLevel;

public interface OneLevelMapper {
	public List<OneLevel> getAllOne();

	public OneLevel getOnlyOne(String oneLevelName);
	
	public OneLevel getOneByID(int oneLevelID);
	
	public boolean insertOne(OneLevel oneLevel);

	public boolean deleteOne(String oneLevelName);

	public boolean updateOne(OneLevel oneLevel);
}
