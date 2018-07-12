package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.User;
import service.UserService;

@Controller
public class RegisteredAction {
	@Autowired
	private UserService userService;

	//用户注册，管理员以及信息录入员需要其他管理赋予,测试完成
	@RequestMapping("/Registered")
	public ModelAndView Registered(String username, String userpassword, String userPhone, String userAddress,
			String userEmail) {
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(userpassword);
		user.setUserPhone(userPhone);
		user.setUserAddress(userAddress);
		user.setUserEmail(userEmail);
		if (userService.registered(user)) {
			System.out.println("注册成功");
			return new ModelAndView("");
		} else {
			System.out.println("注册失败");
			return new ModelAndView("");
		}
	}
}
