package org.firework.sfs.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String get() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected String login(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe != null);
		String msg = null;

		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			msg = "wrong username";
		} catch (IncorrectCredentialsException e) {
			msg = "wrong password";
		} catch (AuthenticationException e) {
			msg = "server error";
		}

		if (msg != null) {
			model.addAttribute("msg", msg);
			// TODO 保存用户名。在别处实现？
			model.addAttribute("cached_username", username);
			return "login";
		} else {
			return "redirect:/menu";
		}
	}
}
