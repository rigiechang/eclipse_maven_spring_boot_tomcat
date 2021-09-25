package com.rigie.eclipse.maven.repository;

/* Import to be use for repositories */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
Error:
import org.springframework.data.repository.CrudRepository;
Syntax error on token ; 

Fix:
The package statement must be first in the file, before anything, even imports:

add import to all other import lines such as
com.rigie.eclipse.maven.model.Contact

Fix:
import com.rigie.eclipse.maven.model.Contact;
 */

/* Get the model / entity */
import com.rigie.eclipse.maven.model.ContactEntity;


//This will be AUTO IMPLEMENTED by Spring into a Bean called contactRepository
//CRUD refers Create, Read, Update, Delete

/*
public class ContactRepository extends CrudRepository<User, Integer> {

Error: must implement inherited abstract method

Fix: change class to interface
public interface ContactRepository extends CrudRepository<User, Integer> {
 */

/*
public interface ContactRepository extends CrudRepository<User, Integer> {

Error: User cannot be resolved to a type

Fix: change to the POJO you imported above for hibernate, User -> Contact
 */

// https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/repositories.html

// Repository is an interface and provides implementations for CRUD
// including: count, delete, deleteById, save, saveAll, findById, findAll

// JpaRepository inherits from CrudRepository and has all of CrudRepo's features

// Integer is the type of the primary key of Contact

/* 	Error:
 * 
 * maven context failed to start
 * 
 * Logs Catalina at : D:\Tomcat\apache-tomcat-9.0.53\logs
 * 
 * Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.rigie.eclipse.maven.repository.ContactRepository' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
		at org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoMatchingBeanFound(DefaultListableBeanFactory.java:1506)
		
   The type Optional cannot be resolved , indirectly referenced
   
Spring Boot 1.4.1.RELEASE is the latest version that works with Java 7.

Every later version require min Java 8.

fix: right click project, set compiler to 1.8, set Facets java to 1.8
		
*/

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {

}
