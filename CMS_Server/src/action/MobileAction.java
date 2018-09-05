package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Content;
import entity.OneLevel;
import entity.TwoLevel;
import service.ContentService;
import service.OneLevelService;
import service.TwoLevelService;

@Controller
@CrossOrigin
public class MobileAction {
	@Autowired
	private OneLevelService oneLevelService;
	@Autowired
	private TwoLevelService twoLevelService;
	@Autowired
	private ContentService contentService;

	@RequestMapping(value = "/getAllLevel", method = RequestMethod.GET)
	@ResponseBody
	//输出所有一级栏目一级二级栏目
	public Map<String, Object> getAllLevel() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OneLevel> onelevels = oneLevelService.getAllOne();
		List<TwoLevel> twolevels = twoLevelService.getAllTwo();
		for (int k = 0; k < onelevels.size(); k++) {
			List<String> twoLevelNames = new ArrayList<>();
			List<TwoLevel> twoLevels2 = new ArrayList<>();
			for (int j = 0; j < twolevels.size(); j++) {
				int oneLevelID = onelevels.get(k).getOneLevelID();
				int oneLevelIDByTwo = twolevels.get(j).getOneLevelID();
				if (oneLevelID == oneLevelIDByTwo) {
					twoLevelNames.add(twolevels.get(j).getTwoLevelName());
					twoLevels2.add(twolevels.get(j));
				}
			}
			if (twoLevelNames.size() == 0 || null == twoLevelNames) {

			} else {
				onelevels.get(k).setTwoLevelNames(twoLevelNames);
				onelevels.get(k).setTwoLevels(twoLevels2);
			}
		}		
		map.put("onelevels", onelevels);
		return map;
	}	
	
	@RequestMapping(value = "/getConByTwoToAPP", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getConByTwoToAPP(int twoLevelID){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Content> contents = contentService.getConByTwo(twoLevelID);
		map.put("contents", contents);
		return map;
	}

	@RequestMapping(value = "/getAllConToAPP", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getConByTwoToAPP(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Content> contents = contentService.getAllCon();
		map.put("contents", contents);
		return map;
	}
}
