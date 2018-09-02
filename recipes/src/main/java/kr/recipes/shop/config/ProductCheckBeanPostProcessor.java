package kr.recipes.shop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import kr.recipes.shop.domain.Product;

@Component
public class ProductCheckBeanPostProcessor implements BeanPostProcessor {
	private static final Logger logger = LoggerFactory.getLogger(ProductCheckBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Product) {
			String productName = ((Product) bean).getName();
			logger.debug("In AuditCheckBeanPostProcessor.postProcessBeforeInitialization," + "processing product : "
					+ productName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Product) {
			String productName = ((Product) bean).getName();
			logger.debug("In AuditCheckBeanPostProcessor.postProcessAfterInitialization," + "processing product : "
					+ productName);
		}
		return bean;
	}
}
