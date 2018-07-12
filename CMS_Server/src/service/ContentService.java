package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Content;
import mapper.ContentMapper;

@Service
public class ContentService {
	@Autowired
	private ContentMapper contentMapper;

	public List<Content> getConByTwo(int twoLevelID) {
		return contentMapper.getConByTwo(twoLevelID);
	}

	public Content getConByID(int conID) {
		return contentMapper.getConByID(conID);
	}

	public boolean insertCon(Content content) {
		return contentMapper.insertCon(content);
	}

	public boolean deleteCon(int conID) {
		return contentMapper.deleteCon(conID);
	}

	public boolean deleteConByTwo(int twoLevelID) {
		return contentMapper.deleteConByTwo(twoLevelID);
	}

	public boolean updateCon(Content content) {
		return contentMapper.updateCon(content);
	}

	public boolean updateConWithClick(Content content) {
		return contentMapper.updateConWithClick(content);
	}
}
