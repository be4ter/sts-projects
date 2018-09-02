package kr.recipes.sequenceGenerator.sequence;

public class Sequence {
	private String id;
	private String prefix;
	private String suffix;

	public Sequence() {
		super();
	}

	public Sequence(String id, String prefix, String suffix) {
		super();
		this.id = id;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getPrefix() {
		return prefix;
	}

}
