package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Admin;
import entity.Reporter;
import entity.User;
import service.AdminService;
import service.ReporterService;
import service.UserService;

@Controller
public class LoginAction {
	@Autowired
	private UserService userService;

	@Autowired
	private ReporterService reporterService;

	@Autowired
	private AdminService adminService;

	// 登录判断，测试完成
	@RequestMapping("/loginIn")
	public ModelAndView loginIn(String username, String userpassword, HttpSession session, String select) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (select.equals("管理员")) {
			List<Admin> admins = adminService.loginInAdmin();
			for (int i = 0; i < admins.size(); i++) {
				if (username.equals(admins.get(i).getAdminName())
						&& userpassword.equals(admins.get(i).getAdminPassword())) {
					session.setAttribute("username", username);
					session.setAttribute("Permission", "admin");
					return new ModelAndView("adminView", model);
				}
			}
		} else if (select.equals("信息录入员")) {
			List<Reporter> reporters = reporterService.loginInReporter();
			for (int i = 0; i < reporters.size(); i++) {
				if (username.equals(reporters.get(i).getReporterName())
						&& userpassword.equals(reporters.get(i).getReporterPassword())) {
					session.setAttribute("username", username);
					session.setAttribute("Permission", "reporter");
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
					return new ModelAndView("home", model);
				}
			}

		}
		model.put("error", "请选择登录权限");
		return new ModelAndView("login", model);
	}

	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeacher(@PathVariable("username") String username, @PathVariable("password") String password){ 
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("拦截了客户端json请求");
		System.out.println(username);
		System.out.println(password);
		return null;
	}
		
	
	
	
}
