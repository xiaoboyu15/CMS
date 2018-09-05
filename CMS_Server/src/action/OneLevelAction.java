package action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.OneLevel;
import entity.TwoLevel;
import service.ContentService;
import service.OneLevelService;
import service.TwoLevelService;

@Controller
public class OneLevelAction {
	@Autowired
	private OneLevelService oneLevelService;
	@Autowired
	private TwoLevelService twoLevelService;
	@Autowired
	private ContentService contentService;

	
	@RequestMapping("/goToAdminHome")
	public ModelAndView goToAdminHome() {
		return new ModelAndView("adminHome");
	}
	// 获取所有的一级栏目,测试通过
	@RequestMapping("/getAllOne")
	public ModelAndView getAllOne() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<OneLevel> onelevels = oneLevelService.getAllOne();
		List<TwoLevel> twolevels = twoLevelService.getAllTwo();
		model.put("onelevels", onelevels);
		model.put("twolevels", twolevels);
		return new ModelAndView("", model);
	}

	// 插入一级栏目，测试完成
	@RequestMapping("/insertOne")
	public String insertOne(String oneLevelName) {
		List<OneLevel> onelevels = oneLevelService.getAllOne();
		for (int i = 0; i < onelevels.size(); i++) {
			if (oneLevelName.equals(onelevels.get(i).getOneLevelName())) {
				return "forward:/goToNeirong.do";
			}
		}
		OneLevel oneLevel = new OneLevel();
		oneLevel.setOneLevelName(oneLevelName);
		if (oneLevelService.insertOne(oneLevel)) {
			return "forward:/goToNeirong.do";
		} else {
			return "forward:/goToNeirong.do";
		}
	}

	// 删除一级栏目，测试完成
	@RequestMapping("/deleteOne")
	public String deleteOne(String oneLevelName) {
		OneLevel oneLevel = oneLevelService.getOnlyOne(oneLevelName);
		List<TwoLevel> twoLevel = twoLevelService.getTwoByOne(oneLevel.getOneLevelID());
		for (int i = 0; i < twoLevel.size(); i++) {
			if (contentService.deleteConByTwo(twoLevel.get(i).getTwoLevelID())) {
			}
		}
		if (twoLevelService.deleteTwoByOne(oneLevel.getOneLevelID())) {
		}
		if (oneLevelService.deleteOne(oneLevelName)) {
			return "forward:/goToNeirong.do";
		}
		return "forward:/goToNeirong.do";
	}

	// 修改一级栏目，测试完成
	@RequestMapping("/updateOne")
	public String updateOne(String oneLevelName,String disoneLevelName,String[] distwoLevelName,String[] twoLevelName) {
		OneLevel oneLevel = new OneLevel();
		oneLevel.setOneLevelName(oneLevelName);
		OneLevel tempOne=oneLevelService.getOnlyOne(disoneLevelName);
		oneLevel.setOneLevelID(tempOne.getOneLevelID());
		if (oneLevelService.updateOne(oneLevel)) {
			for(int i=0;i<twoLevelName.length;i++) {
				TwoLevel twoLevel =new TwoLevel();
				if(twoLevelName[i].equals("")) {
					twoLevelService.deleteTwo(twoLevelName[i]);
				}
				twoLevel.setTwoLevelName(twoLevelName[i]);
				TwoLevel onlyTwo=twoLevelService.getOnlyTwo(distwoLevelName[i]);
				twoLevel.setTwoLevelID(onlyTwo.getTwoLevelID());
				twoLevelService.updateTwo(twoLevel);
			}
			return "forward:/goToNeirong.do";
		}
		return "forward:/goToNeirong.do";
	}

	@RequestMapping("/update")
	public ModelAndView Update(int oneLevelID) {
		Map<String, Object> model = new HashMap<String, Object>();
		OneLevel oneLevels=oneLevelService.getOneByID(oneLevelID);
		List<TwoLevel> twoLevels =twoLevelService.getTwoByOne(oneLevelID);
//		List<String> twoLevelNames=new ArrayList<>();
//		for(int i=0;i<twoLevels.size();i++) {
//			twoLevelNames.add(twoLevels.get(i).getTwoLevelName());
//		}
//		oneLevels.setTwoLevelNames(twoLevelNames);
		model.put("oneLevels", oneLevels);
		model.put("twoLevels", twoLevels);
		return new ModelAndView("updateLevel",model);
	}
	

}
