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
	
	@RequestMapping("/Registered")
	public void Registered(String username,String userpassword,String userPhone,String userAddress,String userEmail) {
		User user=new User();
		System.out.println(username);
		System.out.println(userpassword);
		System.out.println(userPhone);
		System.out.println(userAddress);
		System.out.println(userEmail);
		
		user.setUserName(username);
		user.setUserPassword(userpassword);
		user.setUserPhone(userPhone);
		user.setUserAddress(userAddress);
		user.setUserEmail(userEmail);
		if(userService.registered(user)) {
			System.out.println("×¢²á³É¹¦");
		}
		else {
			System.out.println("×¢²áÊ§°Ü");
		}
	}
}
