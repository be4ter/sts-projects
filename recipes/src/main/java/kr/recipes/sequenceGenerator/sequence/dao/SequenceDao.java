package kr.recipes.sequenceGenerator.sequence.dao;

import kr.recipes.sequenceGenerator.sequence.Sequence;

public interface SequenceDao {
	public Sequence getSequence(String sequenceId);

	public int getNextValue(String sequenceId);
}
