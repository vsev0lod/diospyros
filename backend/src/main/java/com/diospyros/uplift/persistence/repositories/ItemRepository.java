/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.persistence.repositories;

import com.diospyros.uplift.persistence.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data JPA repository for entity "Item" <br>
 * <p>
 * This repository extends PagingAndSortingRepository interface <br>
 * so it provides by default all the basic CRUD operations : <br>
 * findById, findAll, save, delete, etc <br>
 * with pagination and sorting : <br>
 * findAll(Pageable), findAll(Sort)<br>
 * <p>
 * This repository can be extended by adding specific "finders" methods<br>
 * To do so, see the "predicates conventions" for "derived query methods" in Spring Data documentation
 *
 * @author Telosys
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    // Insert specific finders here

    //List<Item> findByXxx(String xxx);

    //List<Item> findByXxxStartingWith(String xxx);

    //List<Item> findByXxxContaining(String xxx);

    //List<Item> findByYyy(BigDecimal yyy);

    //List<Item> findByXxxContainingAndYyy(String xxx, BigDecimal yyy);
}
