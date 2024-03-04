package com.youngstone.mastery.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.youngstone.mastery.sequence.Sequence;

@Configuration
public class SequenceConfiguration {
    @Bean
    public Sequence sequence() {
        var seqgen = new Sequence();
        seqgen.setPrefix("30");
        seqgen.setSuffix("A");
        seqgen.setInitial(100000);
        return seqgen;
    }

    @Bean
    public Sequence sequenceTwo() {
        var seqgen = new Sequence();
        seqgen.setPrefix("2");
        seqgen.setSuffix("A");
        seqgen.setInitial(100000);
        return seqgen;
    }

    @Bean(name = "sequenceThree")
    public Sequence sequenceThree() {
        var seqgen = new Sequence();
        seqgen.setPrefix("2");
        seqgen.setSuffix("A");
        seqgen.setInitial(100000);
        return seqgen;
    }
}
