package kr.recipes.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import kr.recipes.shop.domain.Cashier;

@Configuration
@Profile("global")
@ComponentScan("kr.recipes.shop")
public class ShopConfigurationGlobal {
	@Bean(initMethod = "openFile", destroyMethod = "closeFile")
	public Cashier cashier() {
		final String path = System.getProperty("java.io.tmpdir") + "cashier";
		Cashier cashier = new Cashier();
		cashier.setFileName("checkout");
		cashier.setPath(path);
		return cashier;
	}
}
