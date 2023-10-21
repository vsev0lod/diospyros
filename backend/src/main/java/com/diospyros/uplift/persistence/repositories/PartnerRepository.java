/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.diospyros.uplift.persistence.entities.Partner;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for entity "Partner" <br> 
 * 
 * This repository extends PagingAndSortingRepository interface <br>
 * so it provides by default all the basic CRUD operations : <br>
 *   findById, findAll, save, delete, etc <br> 
 * with pagination and sorting : <br>
 *   findAll(Pageable), findAll(Sort)<br>
 * 
 * This repository can be extended by adding specific "finders" methods<br>
 * To do so, see the "predicates conventions" for "derived query methods" in Spring Data documentation
 * 
 * @author Telosys
 *
 */
@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {

	// Insert specific finders here 

	//List<Partner> findByXxx(String xxx);

	//List<Partner> findByXxxStartingWith(String xxx);

	//List<Partner> findByXxxContaining(String xxx);

	//List<Partner> findByYyy(BigDecimal yyy);

	//List<Partner> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
