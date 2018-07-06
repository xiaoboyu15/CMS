package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	//登录验证逻辑
	@RequestMapping("/loginIn")
	public ModelAndView loginIn(String username,String userpassword,HttpSession session,String select) {
		System.out.println(username);
		System.out.println("111");
		//String message="账号或密码错误，请重试！";
		Map<String,Object> model = new HashMap<String,Object>();
		if(select.equals("管理员")) {
			List<Admin> admins=adminService.loginInAdmin();
			for(int i=0;i<admins.size();i++) {
				if(username.equals(admins.get(i).getAdminName())&&userpassword.equals(admins.get(i).getAdminPassword())) {
					session.setAttribute("username", username);
					return new ModelAndView("adminView",model);
				}
			}
		}
		else if(select.equals("信息录入员")) {
			List<Reporter> reporters=reporterService.loginInReporter();
			for(int i=0;i<reporters.size();i++) {
				if(username.equals(reporters.get(i).getReporterName())&&userpassword.equals(reporters.get(i).getReporterPassword())) {
					session.setAttribute("username", username);
					return new ModelAndView("home",model);
				}
			}
		}
		else if(select.equals("用户")) {
			List<User> users=userService.loginInUser();
			for(int i=0;i<users.size();i++) {
				if(username.equals(users.get(i).getUserName())&&userpassword.equals(users.get(i).getUserPassword())) {
					session.setAttribute("username", username);
					System.out.println("111");
					return new ModelAndView("home",model);
				}
			}
			
		}
		else{
			
		}
		
		return new ModelAndView("login");
	}
}
