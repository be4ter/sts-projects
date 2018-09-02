package kr.recipes.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import kr.recipes.shop.domain.Product;
import kr.recipes.shop.domain.ProductCreator;

@Configuration
@Profile({ "summer, winter" })
public class ShopConfigurationSumWin {
	@Bean
	public Product aaa() {
		return ProductCreator.createProduct("aaa");
	}

	@Bean
	public Product cdrw() {
		return ProductCreator.createProduct("cdrw");
	}

	@Bean
	public Product dvdrw() {
		return ProductCreator.createProduct("dvdrw");
	}

}
