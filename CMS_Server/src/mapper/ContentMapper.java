package mapper;

import java.util.List;

import entity.Content;

public interface ContentMapper {

	public List<Content> getConByTwo(int twoLevelID);

	public Content getConByID(int conID);

	public boolean insertCon(Content content);

	public boolean deleteCon(int conID);

	public boolean deleteConByTwo(int twoLevelID);

	public boolean updateCon(Content content);

	public boolean updateConWithClick(Content content);
}
