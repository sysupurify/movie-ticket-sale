package org.sysupurify.tickets.application;

import java.math.BigDecimal;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sysupurify.tickets.business.entity.Product;
import org.sysupurify.tickets.business.entity.User;
import org.sysupurify.tickets.business.service.IProductService;
import org.sysupurify.tickets.business.service.IUserService;

public class Init {
	@Autowired
	private IUserService userService;
	@Autowired
	private IProductService productService;

	public void doInit() {

		// 创建一个用户
		User user = createUser("a", "a");
		userService.create(user);

		initProduct();

	}

	private void initProduct() {

		final Product prod1 = new Product("Fresh Sweet Basil", true, new BigDecimal("4.99"));
		final Product prod2 = new Product("Italian Tomato", false, new BigDecimal("1.25"));
		final Product prod3 = new Product("Yellow Bell Pepper", true, new BigDecimal("2.50"));
		final Product prod4 = new Product("Old Cheddar", true, new BigDecimal("18.75"));
		final Product prod5 = new Product("Extra Virgin Coconut Oil", true, new BigDecimal("6.34"));
		final Product prod6 = new Product("Organic Tomato Ketchup", true, new BigDecimal("1.99"));
		final Product prod7 = new Product("Whole Grain Oatmeal Cereal", true, new BigDecimal("3.07"));
		final Product prod8 = new Product("Traditional Tomato & Basil Sauce", true, new BigDecimal("2.58"));
		final Product prod9 = new Product("Quinoa Flour", true, new BigDecimal("3.02"));
		final Product prod10 = new Product("Grapefruit Juice", true, new BigDecimal("2.58"));
		final Product prod11 = new Product("100% Pure Maple Syrup", true, new BigDecimal("5.98"));
		final Product prod12 = new Product("Marinara Pasta Sauce", false, new BigDecimal("2.08"));
		final Product prod13 = new Product("Vanilla Puff Cereal", false, new BigDecimal("1.75"));
		final Product prod14 = new Product("Extra Virgin Oil", false, new BigDecimal("5.01"));
		final Product prod15 = new Product("Roasted Garlic Pasta Sauce", true, new BigDecimal("2.40"));
		final Product prod16 = new Product("Canned Minestrone Soup", true, new BigDecimal("2.19"));
		final Product prod17 = new Product("Almond Milk 1L", true, new BigDecimal("3.24"));
		final Product prod18 = new Product("Organic Chicken & Wild Rice Soup", true, new BigDecimal("3.17"));
		final Product prod19 = new Product("Purple Carrot, Blackberry, Quinoa & Greek Yogurt", true,
				new BigDecimal("8.88"));
		final Product prod20 = new Product("Pumpkin, Carrot and Apple Juice", false, new BigDecimal("3.90"));
		final Product prod21 = new Product("Organic Canola Oil", true, new BigDecimal("10.13"));
		final Product prod22 = new Product("Potato Corn Tortilla Chips", true, new BigDecimal("2.44"));
		final Product prod23 = new Product("Canned Corn Chowder Soup", true, new BigDecimal("2.30"));
		final Product prod24 = new Product("Organic Lemonade Juice", true, new BigDecimal("2.48"));
		final Product prod25 = new Product("Spicy Basil Dressing", true, new BigDecimal("4.72"));
		final Product prod26 = new Product("Sweet Agave Nectar", true, new BigDecimal("6.46"));
		final Product prod27 = new Product("Dark Roasted Peanut Butter", false, new BigDecimal("3.48"));
		final Product prod28 = new Product("Unsweetened Lemon Green Tea", true, new BigDecimal("18.34"));
		final Product prod29 = new Product("Whole Grain Flakes Cereal", true, new BigDecimal("3.52"));
		final Product prod30 = new Product("Berry Chewy Granola Bars", true, new BigDecimal("4.00"));

		productService.create(prod1);
		productService.create(prod2);
		productService.create(prod3);
		productService.create(prod4);
		productService.create(prod5);
		productService.create(prod6);
		productService.create(prod7);
		productService.create(prod8);
		productService.create(prod9);
		productService.create(prod10);
		productService.create(prod11);
		productService.create(prod12);
		productService.create(prod13);
		productService.create(prod14);
		productService.create(prod15);
		productService.create(prod16);
		productService.create(prod17);
		productService.create(prod18);
		productService.create(prod19);
		productService.create(prod20);
		productService.create(prod21);
		productService.create(prod22);
		productService.create(prod23);
		productService.create(prod24);
		productService.create(prod25);
		productService.create(prod26);
		productService.create(prod27);
		productService.create(prod28);
		productService.create(prod29);
		productService.create(prod30);

		// prod2.getComments().add(new Comment(1, "I'm so sad this product is no
		// longer available!"));
		// prod2.getComments().add(new Comment(2, "When do you expect to have it
		// back?"));
		//
		// prod13.getComments().add(new Comment(3, "Very tasty! I'd definitely
		// buy it again!"));
		// prod13.getComments().add(new Comment(4, "My kids love it!"));
		// prod13.getComments().add(new Comment(5, "Good, my basic breakfast
		// cereal. Though maybe a bit in the sweet side..."));
		// prod13.getComments().add(new Comment(6, "Not that I find it bad, but
		// I think the vanilla flavouring is too intrusive"));
		// prod13.getComments().add(new Comment(7, "I agree with the excessive
		// flavouring, but still one of my favourites!"));
		// prod13.getComments().add(new Comment(8, "Cheaper than at the local
		// store!"));
		// prod13.getComments().add(new Comment(9, "I'm sorry to disagree, but
		// IMO these are far too sweet"));
		// prod13.getComments().add(new Comment(10, "Good. Pricey though."));
		//
		//
		// prod9.getComments().add(new Comment(11, "Made bread with this and it
		// was great!"));
		// prod9.getComments().add(new Comment(12, "Note: this comes actually
		// mixed with wheat flour"));
		//
		// prod14.getComments().add(new Comment(13, "Awesome Spanish oil. Buy it
		// now."));
		// prod14.getComments().add(new Comment(14, "Would definitely buy it
		// again. Best one I've tasted"));
		// prod14.getComments().add(new Comment(15, "A bit acid for my taste,
		// but still a very nice one."));
		// prod14.getComments().add(new Comment(16, "Definitely not the average
		// olive oil. Really good."));
		//
		// prod16.getComments().add(new Comment(17, "Great value!"));
		//
		// prod24.getComments().add(new Comment(18, "My favourite :)"));
		//
		// prod30.getComments().add(new Comment(19, "Too hard! I would not buy
		// again"));
		// prod30.getComments().add(new Comment(20, "Taste is OK, but I agree
		// with previous comment that bars are too hard to eat"));
		// prod30.getComments().add(new Comment(21, "Would definitely NOT buy
		// again. Simply unedible!"));
	}

	private User createUser(String username, String password) {
		String salt = username;
		Md5Hash hash = new Md5Hash(password, salt);
		password = hash.toString();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSalt(salt);

		return user;
	}
}
