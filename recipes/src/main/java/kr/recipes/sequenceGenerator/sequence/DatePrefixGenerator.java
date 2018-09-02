package kr.recipes.sequenceGenerator.sequence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@DatePrefixAnnotation
public class DatePrefixGenerator implements PrefixGenerator {

	private String pattern;

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String getPrefix() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(new Date());
	}

}
