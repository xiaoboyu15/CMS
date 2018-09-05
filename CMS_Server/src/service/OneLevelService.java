package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.OneLevel;
import mapper.OneLevelMapper;

@Service
public class OneLevelService {
	@Autowired
	private OneLevelMapper oneLevelMapper;

	public List<OneLevel> getAllOne() {
		return oneLevelMapper.getAllOne();
	}

	public OneLevel getOnlyOne(String oneLevelName) {
		return oneLevelMapper.getOnlyOne(oneLevelName);
	}
	
	public OneLevel getOneByID(int oneLevelID) {
		return oneLevelMapper.getOneByID(oneLevelID);
	}

	public boolean insertOne(OneLevel oneLevel) {
		return oneLevelMapper.insertOne(oneLevel);
	}

	public boolean deleteOne(String oneLevelName) {
		return oneLevelMapper.deleteOne(oneLevelName);
	}

	public boolean updateOne(OneLevel oneLevel) {
		return oneLevelMapper.updateOne(oneLevel);
	}
}
