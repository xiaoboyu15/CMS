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
		System.out.println(twolevels.size());
		return new ModelAndView("", model);
	}

	// 插入二级栏目，测试通过
	@RequestMapping("/insertTwo")
	public ModelAndView insertTwo(String twoLevelName, int oneLevelID) {
		List<TwoLevel> twolevels = twoLevelService.getTwoByOne(oneLevelID);
		for (int i = 0; i < twolevels.size(); i++) {
			if (twoLevelName.equals(twolevels.get(i).getTwoLevelName())) {
				System.out.println("该名称已存在");
				return new ModelAndView("");
			}
		}
		TwoLevel twoLevel = new TwoLevel();
		twoLevel.setTwoLevelName(twoLevelName);
		twoLevel.setOneLevelID(oneLevelID);
		if (twoLevelService.insertTwo(twoLevel)) {
			System.out.println("二级栏目插入成功");
			return new ModelAndView("");
		} else {
			System.out.println("二级栏目插入失败");
			return new ModelAndView("");
		}
	}

	// 删除二级栏目
	@RequestMapping("/deleteTwo")
	public ModelAndView deleteTwo(String twoLevelName) {
		TwoLevel twoLevel = twoLevelService.getOnlyTwo(twoLevelName);
		if (contentService.deleteConByTwo(twoLevel.getTwoLevelID())) {
			System.out.println("对应内容删除成功");
		}
		if (twoLevelService.deleteTwo(twoLevelName)) {
			System.out.println("二级栏目删除成功");
			return new ModelAndView("");
		}
		System.out.println("二级栏目删除失败");
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
			System.out.println("修改二级栏目成功");
			return new ModelAndView("");
		} else {
			System.out.println("修改二级栏目失败");
			return new ModelAndView("");
		}
	}
}
