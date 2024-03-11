package com.youngstone.mastery.domain;

import com.youngstone.mastery.sequence.Sequence;

public interface SequenceDao {
    Sequence getSequence(String sequenceId);

    int getNextValue(String sequenceId);
}
