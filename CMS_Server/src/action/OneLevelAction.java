package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView insertOne(String oneLevelName) {
		List<OneLevel> onelevels = oneLevelService.getAllOne();
		for (int i = 0; i < onelevels.size(); i++) {
			if (oneLevelName.equals(onelevels.get(i).getOneLevelName())) {
				System.out.println("该名称已存在");
				return new ModelAndView("");
			}
		}
		OneLevel oneLevel = new OneLevel();
		oneLevel.setOneLevelName(oneLevelName);
		if (oneLevelService.insertOne(oneLevel)) {
			System.out.println("一级栏目插入成功");
			return new ModelAndView("");
		} else {
			System.out.println("一级栏目插入失败");
			return new ModelAndView("");
		}
	}

	// 删除一级栏目，测试完成
	@RequestMapping("/deleteOne")
	public ModelAndView deleteOne(String oneLevelName) {
		OneLevel oneLevel = oneLevelService.getOnlyOne(oneLevelName);
		List<TwoLevel> twoLevel = twoLevelService.getTwoByOne(oneLevel.getOneLevelID());
		for (int i = 0; i < twoLevel.size(); i++) {
			if (contentService.deleteConByTwo(twoLevel.get(i).getTwoLevelID())) {
				System.out.println("删除内容中");
			}
		}
		if (twoLevelService.deleteTwoByOne(oneLevel.getOneLevelID())) {
			System.out.println("对应二级栏目删除成功");
		}
		if (oneLevelService.deleteOne(oneLevelName)) {
			System.out.println("一级栏目删除成功");
			return new ModelAndView("");
		}
		System.out.println("一级栏目删除失败");
		return new ModelAndView("");
	}

	// 修改一级栏目，测试完成
	@RequestMapping("/updateOne")
	public ModelAndView updateOne(int oneLevelID, String oneLevelName) {
		OneLevel oneLevel = new OneLevel();
		oneLevel.setOneLevelName(oneLevelName);
		oneLevel.setOneLevelID(oneLevelID);
		if (oneLevelService.updateOne(oneLevel)) {
			System.out.println("一级栏目修改成功");
			return new ModelAndView("");
		}
		System.out.println("一级栏目修改失败");
		return new ModelAndView("");
	}

	// 富文本传值测试，通过
	@RequestMapping("/test")
	public void test(String text) {
		System.out.println(text);
	}

}
