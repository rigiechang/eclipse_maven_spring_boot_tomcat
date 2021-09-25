package com.rigie.eclipse.maven.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
https://github.com/eugenp/tutorials/blob/master/spring-web-modules/spring-mvc-basics/src/main/java/com/baeldung/spring/web/config/WebConfig.java
https://www.baeldung.com/spring-mvc-view-resolver-tutorial
https://www.baeldung.com/spring-boot-jsp
https://htr3n.github.io/2018/12/jsp-spring-boot/ 
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	/*
    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        bean.setOrder(2);
        return bean;
    }	
    */

	/*
	  @Bean
	  public ViewResolver jspViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/jsp/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	  }
	 */
}
