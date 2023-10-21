/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.persistence.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * JPA entity class for "Item"
 *
 * @author Telosys
 *
 */
@Getter
@Setter
@Entity
@Table(name="item", schema="public" )
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int        id ;

    //--- OTHER DATA FIELDS 
    @Column(name="cost", nullable=false)
    private int        cost ;

    @Column(name="description", nullable=false, length=100)
    private String     description ;

//    @Column(name="partner_id")
//    private Integer    partnerId ;

    //--- LINKS ( RELATIONSHIPS )
    @ManyToOne
    @JoinColumn(name="partner_id", referencedColumnName="id", insertable=false, updatable=false)
    private Partner    partner ;

    /**
     * Constructor
     */`
    public Item() {
		super();
    }

	@Override
	public String toString() { 
		String separator = "|";
		StringBuilder sb = new StringBuilder();
		sb.append("Item[");
		sb.append("id=").append(id);
		sb.append(separator).append("cost=").append(cost);
		sb.append(separator).append("description=").append(description);
//		sb.append(separator).append("partnerId=").append(partnerId);
		sb.append("]");
		return sb.toString();
	}

}
