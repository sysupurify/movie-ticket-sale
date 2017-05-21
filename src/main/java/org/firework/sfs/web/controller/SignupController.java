package org.firework.sfs.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.firework.sfs.business.entity.User;
import org.firework.sfs.business.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String get() {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	protected String login(HttpServletRequest request, Model model) throws ServletException, IOException {
		// TODO 用户名合法性和密码安全性

		String username = request.getParameter("username");

		if (userService.exist(username)) {
			model.addAttribute("msg", "username already exists");
			return "signup";
		}

		String salt = username; // TODO 设置salt为什么比较好
		Md5Hash hash = new Md5Hash(request.getParameter("password"), salt); // MD5加盐加密
		String password = hash.toString();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSalt(salt);
		userService.create(user);

		return "redirect:/login";
	}
}
