package kr;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import kr.recipes.shop.config.ShopConfiguration;
import kr.recipes.shop.domain.Cashier;
import kr.recipes.shop.domain.Product;
import kr.recipes.shop.domain.ShoppingCart;

@SpringBootApplication
public class RecipesApplication {

	private static Logger logger = LoggerFactory.getLogger(RecipesApplication.class);

	public static void main(String[] args) throws IOException {
		// SpringApplication.run(RecipesApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
		Resource resource = new ClassPathResource("discount.properties");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);

		Product aaa = context.getBean("aaa", Product.class);
		Product cdrw = context.getBean("cdrw", Product.class);
		Product dvdrw = context.getBean("dvdrw", Product.class);
		logger.debug("aaa : " + aaa);
		logger.debug("cdrw : " + cdrw);
		logger.debug("dvdrw : " + dvdrw);

		ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
		cart1.addItem(aaa);
		cart1.addItem(cdrw);
		logger.debug("shopping cart 1 contains : " + cart1.getItems());

		ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
		cart2.addItem(dvdrw);
		logger.debug("shopping cart 2 contains : " + cart2.getItems());
		logger.warn(properties.toString());

		Cashier cashier = context.getBean("cashier", Cashier.class);
		cashier.checkout(cart1);
		cashier.checkout(cart2);

	}
}
