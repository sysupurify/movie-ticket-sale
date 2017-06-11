/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.firework.sfs.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.firework.sfs.business.entity.Role;
import org.firework.sfs.business.entity.User;
import org.firework.sfs.business.service.IRoleService;
import org.firework.sfs.business.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BuyController {

	@Autowired
	IUserService userService;
	@Autowired
	IRoleService roleService;

	@RequestMapping("/buy")
	public String getBuy(Model model) {
		return "buy";
	}

	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public String buy(Model model) {
		Subject subject = SecurityUtils.getSubject();
		if (userService.isVip(subject.getPrincipal().toString())) {
			return "buy";
		}
		User user = userService.findByUsername((String) subject.getPrincipal());
		Role vip = roleService.findByRole("vip");
		userService.correlationRoles(user, vip);
		return "redirect:/menu";
	}
}
