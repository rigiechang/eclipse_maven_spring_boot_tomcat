package com.rigie.eclipse.maven.model;

/* Imports for creating hibernate entity */
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
https://stackoverflow.com/questions/26881739/unable-to-get-spring-boot-to-automatically-create-database-schema
 */

// To save data in db with spring jpa, we need an entity model

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "contact") // table name is 'contact'
public class ContactEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto increment in mysql
	private Integer id;
	
	private String fname;
	
	private String lname;
	
	private String comment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactEntity other = (ContactEntity) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", fname=" + fname + ", lname=" + lname + ", comment=" + comment + "]";
	}
	
	

}
