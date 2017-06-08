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
package org.sysupurify.tickets.web.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sysupurify.tickets.business.entity.Movie;
import org.sysupurify.tickets.business.entity.Screening;
import org.sysupurify.tickets.business.entity.User;
import org.sysupurify.tickets.business.service.IMovieService;
import org.sysupurify.tickets.business.service.IScreeningService;
import org.sysupurify.tickets.business.service.IUserService;

@Controller
public class BuyController {

	@Autowired
	IMovieService movieService;
	@Autowired
	IScreeningService screeningService;
	@Autowired
	IUserService userService;

	@RequestMapping(value = "/buy/{screeningId}", method = RequestMethod.POST)
	public String postBuy(Model model, List<Long> seatId) {
		Subject subject = SecurityUtils.getSubject();
		User user = userService.findByUsername((String) subject.getPrincipal());
		if (user == null) // TODO 判断逻辑？
			return "redirect:/menu";
		return "pay";
	}
	
	@RequestMapping(value = "/purchase/{movieId}", method = RequestMethod.GET)
	public String chooseMovie(Model model, @PathVariable String movieId) {
		Movie movie = movieService.findById(Integer.valueOf(movieId));
		model.addAttribute("movie", movie);
		return "Purchase";
	}
	
	@RequestMapping(value = "/purchase/{movieId}/{screeningId}", method = RequestMethod.GET)
	public String chooseScreening(Model model, @PathVariable String movieId, @PathVariable String screeningId) {
		Movie movie = movieService.findById(Integer.valueOf(movieId));
		model.addAttribute("movie", movie);
		Screening screening = screeningService.findById(Integer.valueOf(screeningId));
		model.addAttribute("screening", screening);
		return "Purchase";
	}
	
}
