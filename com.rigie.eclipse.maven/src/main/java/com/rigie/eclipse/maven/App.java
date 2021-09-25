package com.rigie.eclipse.maven;

/*Error: GetMapping cannot be resolved
 *       PostMapping cannot be resolved
 *     
Fix NEW: update version to 2.0.4.RELEASE

    <!-- Inherit defaults from Spring Boot -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.4.RELEASE</version>
    </parent>

 *       
 *       
 Fix OLD: https://stackoverflow.com/questions/50532524/import-org-springframework-web-bind-annotation-deletemapping-cannot-be-resolved
 
4.0.3 release -> upgrade 4.0.2 to 4.0.3 in pom.xml
 */

// https://spring.io/guides/gs/accessing-data-mysql/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rigie.eclipse.maven.model.ContactEntity; // grab the entities for the table association
import com.rigie.eclipse.maven.repository.ContactRepository; // grab the repository used for crud ops

// Ctrl + Shift + o       auto complete imports

/* Error: 404 after maven build success
 * https://stackoverflow.com/questions/39567434/spring-boot-application-gives-404-when-deployed-to-tomcat-but-works-with-embedde
 */

/* Error:
 *  No qualifying bean of type 'com.rigie.eclipse.maven.repository.ContactRepository' available: 
 *  expected at least 1 bean which qualifies as autowire candidate. 
 *  
 *  Fix: add @ComponentScan
 *  
 *  https://stackoverflow.com/questions/54692629/no-qualifying-bean-of-type-repository-personrepository-available
 *  Moved to com.rigie.eclipse.maven  
 *  
 *  https://stackoverflow.com/questions/54692629/no-qualifying-bean-of-type-repository-personrepository-available
 */

@SpringBootApplication  
@ComponentScan({"controller","model","repository", "com.rigie.eclipse.maven.controller"}) // https://stackoverflow.com/questions/54692629/no-qualifying-bean-of-type-repository-personrepository-available
public class App extends SpringBootServletInitializer { //WarInitializerApplication / Application
	
	/* Error: 404 after maven build success
	 I had forgotten to tweak my Application.java file to extend SpringBootServletInitializer and override the configure method.
	 */
    @Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
        return builder.sources(App.class); // WarInitializerApplication.class
    }

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(
        		App.class); // WarInitializerApplication.class
        sa.run(args);
        
        System.out.println("Entered Spring Initializer");
    }	
	
}