package com.youngstone.mastery.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.youngstone.mastery.sequence.Sequence;

@Configuration
public class SequenceConfiguration {
    @Bean
    public Sequence sequence() {
        var seqgen = new Sequence("30", "A", "10000");
        return seqgen;
    }

    @Bean
    public Sequence sequenceTwo() {
        var seqgen = new Sequence("40", "B", "10000");
        return seqgen;
    }

    @Bean(name = "sequenceThree")
    public Sequence sequenceThree() {
        var seqgen = new Sequence("50", "C", "10000");
        return seqgen;
    }
}
