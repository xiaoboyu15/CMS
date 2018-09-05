package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.TwoLevel;
import service.ContentService;
import service.TwoLevelService;

@Controller
public class TwoLevelAction {
	@Autowired
	private TwoLevelService twoLevelService;
	@Autowired
	private ContentService contentService;

	
	// 根据一级栏目ID查询对应二级栏目,测试通过
	@RequestMapping("/getTwoByOne")
	public ModelAndView getTwoByOne(int oneLevelID) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<TwoLevel> twolevels = twoLevelService.getTwoByOne(oneLevelID);
		model.put("twolevels", twolevels);
		return new ModelAndView("", model);
	}

	// 插入二级栏目，测试通过
	@RequestMapping("/insertTwo")
	public String insertTwo(String twoLevelName, int oneLevelID) {
		List<TwoLevel> twolevels = twoLevelService.getTwoByOne(oneLevelID);
		for (int i = 0; i < twolevels.size(); i++) {
			if (twoLevelName.equals(twolevels.get(i).getTwoLevelName())) {
				return "forward:/neirong.jsp";
			}
		}
		TwoLevel twoLevel = new TwoLevel();
		twoLevel.setTwoLevelName(twoLevelName);
		twoLevel.setOneLevelID(oneLevelID);
		twoLevelService.insertTwo(twoLevel);
		return "forward:/goToNeirong.do";
		
	}

	// 删除二级栏目
	@RequestMapping("/deleteTwo")
	public ModelAndView deleteTwo(String twoLevelName) {
		TwoLevel twoLevel = twoLevelService.getOnlyTwo(twoLevelName);
		if (contentService.deleteConByTwo(twoLevel.getTwoLevelID())) {
		}
		if (twoLevelService.deleteTwo(twoLevelName)) {
			return new ModelAndView("");
		}
		return new ModelAndView("");
	}

	// 修改二级栏目
	@RequestMapping("/updateTwo")
	public ModelAndView updateTwo(int twoLevelID, String twoLevelName, int oneLevelID) {
		TwoLevel twoLevel = new TwoLevel();
		twoLevel.setTwoLevelID(twoLevelID);
		twoLevel.setTwoLevelName(twoLevelName);
		twoLevel.setOneLevelID(oneLevelID);
		if (twoLevelService.updateTwo(twoLevel)) {
			return new ModelAndView("");
		} else {
			return new ModelAndView("");
		}
	}
}
