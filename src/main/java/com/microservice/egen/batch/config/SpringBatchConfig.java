package com.microservice.egen.batch.config;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.microservice.egen.data.model.Item;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
					ItemReader<Item> itemReader, ItemProcessor<Item,Item> itemProcessor, ItemWriter<Item> itemWriter) {
		
		Step step =stepBuilderFactory.get("ITM-file-load")
				   					  .<Item,Item>chunk(100)
				   					  .reader(itemReader)
				   					  .processor(itemProcessor)
				   					  .writer(itemWriter)
				   					  .build();
		
		Job job = jobBuilderFactory.get("ITM-Load")
						 .incrementer(new RunIdIncrementer())
						 .start(step)
						 .build();
		
		return job;
		
	}
	
	@Bean
	public FlatFileItemReader<Item> itemReader(@Value("${input}") Resource resource){
		
		FlatFileItemReader<Item> flatFileItemReader = new FlatFileItemReader<Item>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV-reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		
		return flatFileItemReader;	
	}

	@Bean
	public LineMapper<Item> lineMapper() {
		DefaultLineMapper<Item> defaultLineMapper= new DefaultLineMapper<Item>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"name","qty"});
		
		BeanWrapperFieldSetMapper<Item>  fieldSetMapper = new BeanWrapperFieldSetMapper<Item>();
		fieldSetMapper.setTargetType(Item.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		
		return defaultLineMapper;
	}

}
