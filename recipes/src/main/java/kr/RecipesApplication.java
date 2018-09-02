package kr;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.recipes.shop.config.ShopConfiguration;
import kr.recipes.shop.domain.Product;

@SpringBootApplication
public class RecipesApplication {

	private static Logger logger = LoggerFactory.getLogger(RecipesApplication.class);

	public static void main(String[] args) throws IOException {
		// SpringApplication.run(RecipesApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
		context.getEnvironment().setActiveProfiles("global", "winter");
		context.scan("kr.recipes.shop");
		// context.refresh();

		Product aaa = context.getBean("aaa", Product.class);
		logger.debug("aaa : " + aaa);
	}
}
