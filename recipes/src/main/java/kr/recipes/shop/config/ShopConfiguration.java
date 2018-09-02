package kr.recipes.shop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import kr.recipes.shop.domain.Battery;
import kr.recipes.shop.domain.Disc;
import kr.recipes.shop.domain.baen.DiscountFactoryBean;

@Configuration
@PropertySource("classpath:discount.properties")
@ComponentScan("kr.recipes.shop")
public class ShopConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(ShopConfiguration.class);
	@Value("${endofyear.discount:0}")
	private double specialEndofyearDiscountField;

	@Value("classpath:banner.txt")
	private Resource banner;

	@Bean
	public Battery aaa() {
		Battery aaa = new Battery("AAA", 2.5);
		return aaa;
	}

	@Bean
	public Disc cdrw() {
		Disc aaa = new Disc("CD-RW", 1.5);
		return aaa;
	}

	@Bean
	public Disc dvdrw() {
		Disc aaa = new Disc("DVD-RW", 3.0);
		return aaa;
	}

	@Bean
	public DiscountFactoryBean discountFactoryBeanAAA() {
		DiscountFactoryBean factory = new DiscountFactoryBean();
		factory.setProduct(aaa());
		factory.setDiscount(0.2);
		return factory;
	}

	@Bean
	public DiscountFactoryBean discountFactoryBeanCDRW() {
		DiscountFactoryBean factory = new DiscountFactoryBean();
		factory.setProduct(cdrw());
		factory.setDiscount(0.1);
		return factory;
	}

	@Bean
	public DiscountFactoryBean discountFactoryBeanDVDRW() {
		DiscountFactoryBean factory = new DiscountFactoryBean();
		factory.setProduct(dvdrw());
		factory.setDiscount(0.1);
		return factory;
	}
}
