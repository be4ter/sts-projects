package kr.recipes.sequenceGenerator.sequence;

import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Required;

public class SequenceGenerator {
	private String prefix;
	private String suffix;
	private int initial;
	private final AtomicInteger counter = new AtomicInteger();
	@Inject
	@DatePrefixAnnotation
	private PrefixGenerator prefixGenerator;

	public SequenceGenerator() {
	}

	public SequenceGenerator(String prefix, String suffix, int initial) {
		super();
		this.prefix = prefix;
		this.suffix = suffix;
		this.initial = initial;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public int getInitial() {
		return initial;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	@Required
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Required
	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}
}
