package org.sysupurify.tickets.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sysupurify.tickets.business.entity.Movie;
import org.sysupurify.tickets.business.service.IMovieService;

@Controller
public class ChooseController {

	@Autowired
	IMovieService movieService;
    
    @ModelAttribute("allMovies")
    public List<Movie> populateSeedStarters() {
    	List<Movie> all = this.movieService.findAll();
    	for (Movie movie : all)
    		System.out.println("#screening " + movie.getScreenings().size());
        return all;
    }

	@RequestMapping({"/ChooseMovie2"})
	public String home() {
		return "ChooseMovie2";
	}
}
