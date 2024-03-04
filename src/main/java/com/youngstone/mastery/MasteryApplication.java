package com.youngstone.mastery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youngstone.mastery.configuration.SequenceConfiguration;
import com.youngstone.mastery.sequence.Sequence;

@SpringBootApplication
public class MasteryApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MasteryApplication.class, args);

		var cfg = SequenceConfiguration.class;
		try (var ctx = new AnnotationConfigApplicationContext(cfg)) {
			var generator = ctx.getBean("sequence", Sequence.class);
			System.out.println(generator.nextValue());
			System.out.println(generator.nextValue());

			var generator2 = (Sequence) ctx.getBean("sequence");

			System.out.println(generator2.nextValue());
			System.out.println(generator == generator2);

			var generatorTwo = ctx.getBean("sequenceTwo", Sequence.class);
			generatorTwo.nextValue();
			generatorTwo.nextValue();
			System.out.println(generatorTwo.nextValue());
		}

	}

}
