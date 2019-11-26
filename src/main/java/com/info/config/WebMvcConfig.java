package com.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.info" })
public class WebMvcConfig implements WebMvcConfigurer {
	
//	@Bean
//    public Docket api() {
//        // @formatter:off
//        //Register the controllers to swagger
//        //Also it is configuring the Swagger Docket
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                // .apis(RequestHandlerSelectors.any())
//                .apis(Predicates.not(RequestHandlerSelectors.basePackage("com.info")))
//                // .paths(PathSelectors.any())
//                // .paths(PathSelectors.ant("/swagger2-demo"))
//                .build();
//        // @formatter:on
//    }

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/message");
		messageSource.setUseCodeAsDefaultMessage(false);
		// messageSource.setCacheSeconds((int) TimeUnit.HOURS.toSeconds(1));
		messageSource.setFallbackToSystemLocale(false);
		return messageSource;
	}

	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(this.messageSource());
		return validator;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(new String[] { "/resources/**" })
				.addResourceLocations(new String[] { "/resources/" });
		// enabling swagger-ui part for visual documentation
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(this.getValidator());
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(100000);
		return multipartResolver;
	}

	// @Bean
	// public StandardServletMultipartResolver multipartResolver() {
	// return new StandardServletMultipartResolver();
	// }

}