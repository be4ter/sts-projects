package kr.recipes.shop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

import kr.recipes.shop.BannerLoader;
import kr.recipes.shop.domain.Battery;
import kr.recipes.shop.domain.Cashier;
import kr.recipes.shop.domain.Disc;
import kr.recipes.shop.domain.Product;

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
	public Product aaa() {
		Battery battery = new Battery();
		battery.setName("AAA");
		battery.setPrice(2.5);
		battery.setRechargeable(true);
		return battery;
	}

	@Bean
	public Product cdrw() {
		Disc disc = new Disc("CD-RW", 3.0, specialEndofyearDiscountField);
		disc.setCapacity(700);
		return disc;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Product dvdrw() {
		Disc disc = new Disc();
		disc.setName("DVD-RW");
		disc.setPrice(1.5);
		disc.setCapacity(700);
		return disc;
	}

	@Bean
	public BannerLoader bannerLoader() {
		BannerLoader bannerLoadder = new BannerLoader();
		bannerLoadder.setBanner(banner);
		return bannerLoadder;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

	@Bean
	public Cashier cashier() {
		String path = System.getProperty("java.io.tmpdir") + "/cashier";
		Cashier cashier = new Cashier();
		cashier.setFileName("checkout");
		cashier.setPath(path);
		logger.debug("path : " + path);
		return cashier;
	}
}
