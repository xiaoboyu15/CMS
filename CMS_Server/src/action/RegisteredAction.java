package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Content;
import entity.LoginWater;
import entity.OneLevel;
import entity.TwoLevel;
import entity.User;
import service.ContentService;
import service.LoginWaterService;
import service.OneLevelService;
import service.TwoLevelService;
import service.UserService;

@Controller
public class RegisteredAction {
	@Autowired
	private UserService userService;
	@Autowired
	private OneLevelService oneLevelService;
	@Autowired
	private TwoLevelService twoLevelService;
	@Autowired
	private ContentService contentService;
	@Autowired
	private LoginWaterService loginWaterService;


	//用户注册，管理员以及信息录入员需要其他管理赋予,测试完成
	@RequestMapping("/Registered")
	public ModelAndView Registered(String username, String userpassword, String userPhone, String userAddress,
			String userEmail,HttpSession session) {
		Map<String, Object> model = new HashMap<String, Object>();
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(userpassword);
		user.setUserPhone(userPhone);
		user.setUserAddress(userAddress);
		user.setUserEmail(userEmail);
		if (userService.registered(user)) {
			session.setAttribute("username", username);
			session.setAttribute("Permission", "user");
			List<Content> contents = contentService.getAllCon();
			model.put("contents", contents);
			LoginWater loginWater=new LoginWater();
			loginWater.setLoginName(username);
			loginWater.setLoginType("user");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			loginWater.setLoginDate(df.format(new Date()));
			loginWaterService.insertLogin(loginWater);
			List<OneLevel> onelevels = oneLevelService.getAllOne();
			List<TwoLevel> twolevels = twoLevelService.getAllTwo();
			for (int k = 0; k < onelevels.size(); k++) {
				List<String> twoLevelNames = new ArrayList<>();
				List<TwoLevel> twoLevels2=new ArrayList<>();
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
			model.put("onelevels", onelevels);
			session.setAttribute("onelevels", onelevels);
			return new ModelAndView("userindex", model);
		} else {
			return new ModelAndView("zhuce" );
		}
		
	}
	
	@RequestMapping("/goToZhuce")
	public ModelAndView goToZhuce() {
		return new ModelAndView("zhuce");
	}
}
