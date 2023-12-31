/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.diospyros.uplift.persistence.entities.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for entity "Users" <br> 
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
public interface UsersRepository extends JpaRepository<Users, UUID> {

	// Insert specific finders here

	Optional<Users> findByEmail(String email);

	//List<Users> findByXxxStartingWith(String xxx);

	//List<Users> findByXxxContaining(String xxx);

	//List<Users> findByYyy(BigDecimal yyy);

	//List<Users> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
