package com.youngstone.mastery.sequence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Sequence {
    private final String id;
    private final String prefix;
    private final String suffix;
}
