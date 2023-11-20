package com.manning.sbip;

import com.manning.sbip.config.AppConfiguration;
import com.manning.sbip.config.AppProperties;
import com.manning.sbip.config.DBConfiguration;
import com.manning.sbip.domain.Course;
import com.manning.sbip.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class CommonSpringBootTasksApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CommonSpringBootTasksApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CommonSpringBootTasksApplication.class, args);
		DBConfiguration dbConfiguration = applicationContext.getBean(DBConfiguration.class);
		logger.info(dbConfiguration.toString());

		AppConfiguration appConfiguration = applicationContext.getBean(AppConfiguration.class);
		logger.info(appConfiguration.toString());

		Environment env = applicationContext.getBean(Environment.class);
		logger.info("OS environment variable: " + env.getProperty("port"));

		AppService appService = applicationContext.getBean(AppService.class);
		logger.info(appService.getAppProperties().toString());

		logger.info("CommonSpringBootTasksApplication started successfully with Log4j2 configuration");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("CommonSpringBootTasksApplication::CommandLineRunner has executed");
		Course course = new Course();
		course.setId(1L);
		course.setRating(0);

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Course>> violations = validator.validate(course);
		violations.forEach(
				courseConstraintViolation -> {
					logger.error("A constraint violation has occurred. Violation details: [{}]", courseConstraintViolation);
				}
		);
	}
}
