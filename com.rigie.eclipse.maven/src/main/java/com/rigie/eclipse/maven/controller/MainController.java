package com.rigie.eclipse.maven.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rigie.eclipse.maven.model.ContactEntity; // grab the entities for the table association
import com.rigie.eclipse.maven.repository.ContactRepository; // grab the repository used for crud ops

// Ctrl + Shift + o       auto complete imports

/* Error: 404 after maven build success
 * https://stackoverflow.com/questions/39567434/spring-boot-application-gives-404-when-deployed-to-tomcat-but-works-with-embedde
 */

/*
Error: http://localhost:8080/DeployMavenToTomcat/  returns 'hello-world-page' string instead of jsp page

Fix: That's because you are using the annotation @RestController instead of @Controller
When you annotate a class with RestController, all methods annotated with @RequestMapping assume @ResponseBody semantics 
by default. In other words, your method #home is serializing the String /webapp/WEB-INF/home.jsp as JSON, 
instead of mapping its value to a view.

@RestController -> @Controller
*/
@Controller
public class MainController { 
	
	@Autowired // dependency injection, on a property
	private ContactRepository contactRepository;
	
/*	
	#Note that Spring Boot will map a logical view onto a JSP file inside the folder 
	#src/main/webapp/WEB-INF/jsp/

	#controller
	#    @GetMapping("/viewBooks")
	#    public String viewBooks(Model model) {
	#        model.addAttribute("books", bookService.getBooks());
	#        return "view-books";
	#    }	
	
	Spring MVC will look for view-books.jsp inside the /WEB-INF/jsp/ directory.
*/	

	/*
	 In order to pass data from controller to JSP, all you have to do is add a ModelMap 
	 argument to your controller method and then populate it inside your method body 
	 using the generic addAttribute() method.
	 */
    @RequestMapping("/")
    public String home(ModelMap model){
    	
    	model.addAttribute("greeting", "This value passed to the JSP page"); // display in JSP page with ${greeting}
    	
    	System.out.println("Hello World !!");
    	
        return "hello-world-page"; // should show 'hello-world-page.jsp'
    }	
	
	
    @GetMapping("/add")
    public String contacts() {
    	
    	ContactEntity contact = new ContactEntity();
    	contact.setFname("bruce");
    	contact.setLname("wayne");
    	contact.setComment("i am batman");
    	
    	contactRepository.save(contact);
    	
    	System.out.println("Contact Added !!");
    	
    	return "contact-add-success";
    }

}
