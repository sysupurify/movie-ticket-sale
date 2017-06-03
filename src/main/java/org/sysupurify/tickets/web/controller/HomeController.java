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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sysupurify.tickets.business.entity.Movie;
import org.sysupurify.tickets.business.entity.Screening;
import org.sysupurify.tickets.business.service.IMovieService;
import org.sysupurify.tickets.business.service.IScreeningService;

@Controller
public class HomeController {

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

	@RequestMapping({"/", "main"})
	public String home() {
		return "test";
	}

}
