/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO class for "Users"
 *
 * @author Telosys
 *
 */
public class UsersDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    private int id ;
    //--- OTHER DATA FIELDS 
    private String email ;
    private String password ;
    private BigDecimal rating ;
    private String userType ;
    private String name ;
    private String description ;
    private BigDecimal balance ;

    /**
     * Constructor
     */
    public UsersDTO() {
		super();
    }
    
    public void setId( int id ) {
        this.id = id ;
    }
    public int getId() {
        return this.id;
    }

    public void setEmail( String email ) {
        this.email = email ;
    }
    public String getEmail() {
        return this.email;
    }

    public void setPassword( String password ) {
        this.password = password ;
    }
    public String getPassword() {
        return this.password;
    }

    public void setRating( BigDecimal rating ) {
        this.rating = rating ;
    }
    public BigDecimal getRating() {
        return this.rating;
    }

    public void setUserType( String userType ) {
        this.userType = userType ;
    }
    public String getUserType() {
        return this.userType;
    }

    public void setName( String name ) {
        this.name = name ;
    }
    public String getName() {
        return this.name;
    }

    public void setDescription( String description ) {
        this.description = description ;
    }
    public String getDescription() {
        return this.description;
    }

    public void setBalance( BigDecimal balance ) {
        this.balance = balance ;
    }
    public BigDecimal getBalance() {
        return this.balance;
    }

	@Override
	public String toString() { 
		String separator = "|";
		StringBuilder sb = new StringBuilder();
		sb.append("Users[");
		sb.append("id=").append(id);
		sb.append(separator).append("email=").append(email);
		sb.append(separator).append("password=").append(password);
		sb.append(separator).append("rating=").append(rating);
		sb.append(separator).append("userType=").append(userType);
		sb.append(separator).append("name=").append(name);
		sb.append(separator).append("description=").append(description);
		sb.append(separator).append("balance=").append(balance);
		sb.append("]");
		return sb.toString();
	}
}
