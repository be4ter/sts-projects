package kr.recipes.sequenceGenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import kr.recipes.sequenceGenerator.sequence.DatePrefixGenerator;
import kr.recipes.sequenceGenerator.sequence.SequenceGenerator;

@Configuration
@ComponentScan(
		includeFilters = {
				@ComponentScan.Filter(
						type = FilterType.REGEX,
						pattern = {"kr.sequenceGenerator.sequence.*Dao",
								"kr.sequenceGenerator.sequence.*Service"})
		},
		excludeFilters = {
				@ComponentScan.Filter(
						type = FilterType.ANNOTATION,
						classes = {org.springframework.stereotype.Controller.class})
				
		})
public class SequenceGeneratorConfiguration {
	@Bean 
	public DatePrefixGenerator datePrefixGenerator() {
		DatePrefixGenerator dpg = new DatePrefixGenerator();
		dpg.setPattern("yyyMMdd");
		return dpg;
	}
	
	@Bean
	public SequenceGenerator sequenceGenerator() {
		SequenceGenerator sequence = new SequenceGenerator();
		sequence.setInitial(10000);
		sequence.setSuffix("A");
		sequence.setPrefixGenerator(datePrefixGenerator());
		return sequence;
	}
}
