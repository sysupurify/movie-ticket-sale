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

import javax.servlet.http.HttpServletRequest;

import org.firework.sfs.business.entity.Product;
import org.firework.sfs.business.service.IProductService;
import org.firework.sfs.business.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CuisineDetailController {

	@Autowired
	IProductService productService;
	@Autowired
	IUserService userService;

	@RequestMapping("/cuisine_detail/{productName}")
	public String detail(HttpServletRequest request, Model model, @PathVariable String productName) {
        final Product product = productService.findByName(productName);
        model.addAttribute("prod", product);
		return "cuisine_detail";
	}

}
