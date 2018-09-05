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

import entity.Administrator;
import entity.Content;
import entity.LoginWater;
import entity.Media;
import entity.OneLevel;
import entity.Reporter;
import entity.TwoLevel;
import entity.User;
import entity.Application;
import service.AdministratorService;
import service.ApplicationService;
import service.ContentService;
import service.LoginWaterService;
import service.MediaService;
import service.OneLevelService;
import service.ReporterService;
import service.TwoLevelService;
import service.UserService;

@Controller
public class LoginAction {
	@Autowired
	private UserService userService;
	@Autowired
	private ReporterService reporterService;
	@Autowired
	private AdministratorService adminService;
	@Autowired
	private OneLevelService oneLevelService;
	@Autowired
	private TwoLevelService twoLevelService;
	@Autowired
	private MediaService mediaService;
	@Autowired
	private ContentService contentService;
	@Autowired
	private LoginWaterService loginWaterService;
	@Autowired
	private ApplicationService applicationService;

	// 登录判断，测试完成
	@RequestMapping("/loginIn")
	public ModelAndView loginIn(String username, String userpassword, HttpSession session, String select) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (select.equals("管理员")) {
			List<Administrator> admins = adminService.loginInAdmin();
			for (int i = 0; i < admins.size(); i++) {
				if (username.equals(admins.get(i).getAdminName())
						&& userpassword.equals(admins.get(i).getAdminPassword())) {
					session.setAttribute("username", username);
					session.setAttribute("Permission", "administrator");
					LoginWater loginWater=new LoginWater();
					loginWater.setLoginName(username);
					loginWater.setLoginType("administrator");
					if (loginWaterService.getLoginWaterByNT(loginWater)!=null) {
						String date =loginWaterService.getLoginWaterByNT(loginWater).getLoginDate();
						session.setAttribute("Date",date);
					}
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					loginWater.setLoginDate(df.format(new Date()));
					loginWaterService.insertLogin(loginWater);
					return new ModelAndView("home", model);
				}
			}
		} else if (select.equals("信息录入员")) {
			List<Reporter> reporters = reporterService.loginInReporter();
			for (int i = 0; i < reporters.size(); i++) {
				if (username.equals(reporters.get(i).getReporterName())
						&& userpassword.equals(reporters.get(i).getReporterPassword())) {
					session.setAttribute("username", username);
					session.setAttribute("Permission", "reporter");
					LoginWater loginWater=new LoginWater();
					loginWater.setLoginName(username);
					loginWater.setLoginType("reporter");
					if (loginWaterService.getLoginWaterByNT(loginWater)!=null) {
						String date =loginWaterService.getLoginWaterByNT(loginWater).getLoginDate();
						session.setAttribute("Date",date);
					}
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					loginWater.setLoginDate(df.format(new Date()));
					loginWaterService.insertLogin(loginWater);
					return new ModelAndView("home", model);
				}
			}
		} else if (select.equals("用户")) {
			List<User> users = userService.loginInUser();
			for (int i = 0; i < users.size(); i++) {
				if (username.equals(users.get(i).getUserName())
						&& userpassword.equals(users.get(i).getUserPassword())) {
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
				}
			}

		}
		model.put("error", "请选择登录权限");
		return new ModelAndView("login", model);
	}

	@RequestMapping("NoSessionLoginOut")
	public String NoSessionLoginOut() {
		return "redirect:/index.jsp";
	}
	@RequestMapping("loginOut")
	public String loginOut(HttpSession session) {
		session.invalidate();
//		session.removeAttribute("username");
//		session.removeAttribute("Permission");
//		session.removeAttribute("Date");
		return "forward:/index.jsp";
	}

	@RequestMapping("goToWo")
	public ModelAndView goToWo(HttpSession session) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<LoginWater> loginWaters = loginWaterService.getLoginWater();
		List<Application> applications=applicationService.getAllApplication();
		model.put("loginWaters", loginWaters);
		model.put("applications", applications);
		return new ModelAndView("wo", model);
	}

	@RequestMapping("goToMeitiku")
	public ModelAndView goToMeitiku() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Media> medias = mediaService.getAllMedia();
		model.put("medias", medias);
		return new ModelAndView("meitiku", model);
	}

	@RequestMapping("goToNeirong")
	public ModelAndView goToNeirong(HttpSession session) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<OneLevel> onelevels = oneLevelService.getAllOne();
		List<TwoLevel> twolevels = twoLevelService.getAllTwo();
		for (int i = 0; i < onelevels.size(); i++) {
			List<String> twoLevelNames = new ArrayList<>();
			for (int j = 0; j < twolevels.size(); j++) {
				int oneLevelID = onelevels.get(i).getOneLevelID();
				int oneLevelIDByTwo = twolevels.get(j).getOneLevelID();
				if (oneLevelID == oneLevelIDByTwo) {
					twoLevelNames.add(twolevels.get(j).getTwoLevelName());
				}
			}
			if (twoLevelNames.size() == 0 || null == twoLevelNames) {

			} else {
				onelevels.get(i).setTwoLevelNames(twoLevelNames);
			}
		}
		List<Media> medias = mediaService.getAllMedia();
		model.put("medias", medias);
		model.put("onelevels", onelevels);
		model.put("twolevels", twolevels);
		session.setAttribute("twolevels", twolevels);
		return new ModelAndView("neirong", model);
	}

	@RequestMapping("goToShezhi")
	public ModelAndView goToShezhi() {
		return new ModelAndView("shezhi");
	}

	@RequestMapping("goToXitong")
	public ModelAndView goToXitong() {
		return new ModelAndView("xitong");
	}
	@RequestMapping("goToUserXitong")
	public ModelAndView goToUserXitong() {
		return new ModelAndView("userXitong");
	}

	@RequestMapping("goToQuestionnaire")
	public ModelAndView goToBiaodan() {
		return new ModelAndView("questionnaire");
	}

	@RequestMapping("goToHome")
	public ModelAndView goToHome() {
		return new ModelAndView("home");
	}
	@RequestMapping("goToQuanxian")
	public ModelAndView goToQuanxian() {
		return new ModelAndView("quanxian");
	}
	@RequestMapping("goToUserQuanxian")
	public ModelAndView goToUserQuanxian() {
		return new ModelAndView("userQuanxian");
	}
	@RequestMapping("getPower")
	public ModelAndView getPower(String select,String why,HttpSession session) {
		Application application=new Application();
		application.setApplicationName((String)session.getAttribute("username"));
		application.setNowPower((String)session.getAttribute("Permission"));
		application.setApplicationPower(select);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		application.setApplicationDate(df.format(new Date()));
		application.setApplicationState(0);
		application.setWhy(why);
		applicationService.insertApplication(application);
		return new ModelAndView("xitong");
	}
	@RequestMapping("getPowerByUser")
	public ModelAndView getPowerByUser(String select,String why,HttpSession session) {
		Application application=new Application();
		application.setApplicationName((String)session.getAttribute("username"));
		application.setNowPower((String)session.getAttribute("Permission"));
		application.setApplicationPower(select);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		application.setApplicationDate(df.format(new Date()));
		application.setApplicationState(0);
		application.setWhy(why);
		applicationService.insertApplication(application);
		return new ModelAndView("userindex");
	}
	@RequestMapping("/goToUserIndex")
	public ModelAndView goToUserIndex() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Content> contents = contentService.getAllCon();
		model.put("contents", contents);
		return new ModelAndView("userindex",model);
	}
	@RequestMapping("/goToIndex")
	public String goToIndex() {
		return "forward:/index.jsp";
	}
	
	@RequestMapping("/agree")
	public String agree(int applicationID,HttpSession session) {
		String power=applicationService.getApplicationByID(applicationID).getApplicationPower();
		String nowPower=applicationService.getApplicationByID(applicationID).getNowPower();
		Application application=new Application();
		application.setApplicationID(applicationID);
		application.setApplicationState(1);
		applicationService.changeState(application);
		if(nowPower.equals("user")&&power.equals("administrator")) {
			String username=applicationService.getApplicationByID(applicationID).getApplicationName();
			User user=userService.getUserByName(username);
			Administrator administrator=new Administrator();
			administrator.setAdminName(username);
			administrator.setAdminPassword(user.getUserPassword());
			adminService.insertAdmin(administrator);
			userService.deleteUser(username);	
		}
		if(nowPower.equals("reporter")&&power.equals("administrator")) {
			String username=applicationService.getApplicationByID(applicationID).getApplicationName();
			Reporter reporter=reporterService.getReporterByName(username);
			Administrator administrator=new Administrator();
			administrator.setAdminName(username);
			administrator.setAdminPassword(reporter.getReporterPassword());
			adminService.insertAdmin(administrator);
			reporterService.deleteReporter(username);
		}
		if(nowPower.equals("user")&&power.equals("reporter")) {
			String username=applicationService.getApplicationByID(applicationID).getApplicationName();
			User user=userService.getUserByName(username);
			Reporter reporter=new Reporter();
			reporter.setReporterName(username);
			reporter.setReporterPassword(user.getUserPassword());
			reporterService.insertReporter(reporter);
			userService.deleteUser(username);	
		}
		return "forward:/goToWo.do";
	}
	@RequestMapping("/refuse")
	public String refuse(int applicationID) {
		Application application=new Application();
		application.setApplicationID(applicationID);
		application.setApplicationState(2);
		applicationService.changeState(application);
		return "forward:/goToWo.do";
	}
	
	@RequestMapping("/removeWater")
	public String removeWater() {
		loginWaterService.removeWater();
		return "forward:/goToWo.do";
	}
}
