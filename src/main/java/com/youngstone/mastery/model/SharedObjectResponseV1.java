package com.youngstone.mastery.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class SharedObjectResponseV1 {
    private int count;
    private int id;
}
