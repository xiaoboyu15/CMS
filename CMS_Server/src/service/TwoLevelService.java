package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.TwoLevel;
import mapper.TwoLevelMapper;

@Service
public class TwoLevelService {
	@Autowired
	private TwoLevelMapper twoLevelMapper;

	public List<TwoLevel> getTwoByOne(int oneLevelID) {
		return twoLevelMapper.getTwoByOne(oneLevelID);
	}

	public List<TwoLevel> getAllTwo() {
		return twoLevelMapper.getAllTwo();
	}

	public TwoLevel getOnlyTwo(String twoLevelName) {
		return twoLevelMapper.getOnlyTwo(twoLevelName);
	}

	public boolean insertTwo(TwoLevel twoLevel) {
		return twoLevelMapper.insertTwo(twoLevel);
	}

	public boolean deleteTwo(String twoLevelName) {
		return twoLevelMapper.deleteTwo(twoLevelName);
	}

	public boolean deleteTwoByOne(int oneLevelID) {
		return twoLevelMapper.deleteTwoByOne(oneLevelID);
	}

	public boolean updateTwo(TwoLevel twoLevel) {
		return twoLevelMapper.updateTwo(twoLevel);
	}
}
