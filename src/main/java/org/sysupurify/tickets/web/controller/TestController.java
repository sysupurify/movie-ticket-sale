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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sysupurify.tickets.business.entity.Movie;
import org.sysupurify.tickets.business.entity.Screening;
import org.sysupurify.tickets.business.service.IMovieService;
import org.sysupurify.tickets.business.service.IScreeningService;

@Controller
public class TestController {

	@Autowired
	IMovieService movieService;
	@Autowired
	IScreeningService screeningService;

	@ModelAttribute("allMovies")
	public List<Movie> populateSeedStarters() {
		List<Movie> all = this.movieService.findAll();
		for (Movie movie : all)
			System.out.println("#screening " + movie.getScreenings().size());
		return all;
	}

	@ModelAttribute("allScreenings")
	public List<Screening> allScreenings() {
		List<Screening> all = this.screeningService.findAll();
		for (Screening screening : all)
			System.out.println("#seat " + screening.getSeats().size());
		return all;
	}

	@RequestMapping({ "test" })
	public String home(final Form form) {
		form.setCovered(true);
		return "test";
	}

	@RequestMapping(value = { "test" }, method = RequestMethod.POST)
	public String get(final Form form, final BindingResult bindingResult) {
		for (Integer integer : form.getArray())
			System.out.println(integer);
		System.out.println(form.getMsg());
		System.out.println(form.getCovered());
		return "test";
	}

}

class Form {

	class MyInt {
		public int val;

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}
		
	}
	
	private String msg = null;
	private Boolean covered = null;
	private Integer array[] = new Integer[4];
	
	public Form() {
		super();
		for (int i = 0; i < 4; i++)
			array[i] = new Integer(0);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Boolean getCovered() {
		return covered;
	}
	public void setCovered(Boolean covered) {
		this.covered = covered;
	}
	public Integer[] getArray() {
		return array;
	}
	public void setArray(Integer[] array) {
		this.array = array;
	}

}
