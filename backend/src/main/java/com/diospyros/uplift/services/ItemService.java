/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.services;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.diospyros.uplift.persistence.entities.Item;
import com.diospyros.uplift.persistence.repositories.ItemRepository;
import com.diospyros.uplift.dto.ItemDTO;
import com.diospyros.uplift.services.commons.GenericService;

/**
 * REST service for entity "Item" <br>
 * 
 * This service provides all the necessary operations required by the REST controller <br>
 * 
 * @author Telosys
 *
 */
@Service
public class ItemService extends GenericService<Item, ItemDTO> {

	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

	private final ItemRepository repository; // injected by constructor

	/**
	 * Constructor (usable for Dependency Injection)
	 * 
	 * @param repository the repository to be injected
	 */
	public ItemService(ItemRepository repository) {
		super(Item.class, ItemDTO.class);
		this.repository = repository;
	}
	
	/**
	 * Returns the entity ID object from the given DTO
	 *
	 * @param dto
	 * @return
	 */
	private Integer getEntityId(ItemDTO dto) {
		return dto.getId();
	}

	/**
	 * Finds all occurrences of the entity
	 *
	 * @return
	 */
	public List<ItemDTO> findAll() {
		logger.debug("findAll()");
		Iterable<Item> all = repository.findAll();
		return entityListToDtoList(all);
	}

	/**
	 * Finds the entity identified by the given PK
	 *
	 * @param id 
	 * @return the entity or null if not found
	 */
	public ItemDTO findById(int id) {
		Integer entityId = id;
		logger.debug("findById({})", entityId);
		Optional<Item> optionalEntity = repository.findById(entityId);
		return entityToDto(optionalEntity);
	}

	/**
	 * Saves the given entity with the given PK <br>
	 * "UPSERT" operation (updated if it exists or created if it does not exist)
	 *
	 * @param id 
	 * @param dto 
	 */
	public void save(int id, ItemDTO dto) {
		Integer entityId = id;
		logger.debug("save({},{})", entityId, dto);
		// force PK in DTO (just to be sure to conform with the given PK) 
		dto.setId(id);
		repository.save(dtoToEntity(dto));
	}

	/**
	 * Updates the given entity if it exists
	 *
	 * @param dto
	 * @return true if updated, false if not found
	 */
	public boolean update(ItemDTO dto) {
		logger.debug("update({})", dto);
		if (repository.existsById(getEntityId(dto))) {
			repository.save(dtoToEntity(dto));
			return true; // find and updated
		} else {
			return false; // not found (not updated)
		}
	}

	/**
	 * Updates partially the given entity if it exists
	 *
	 * @param id 
	 * @param dto
	 * @return true if updated, false if not found
	 */
	public boolean partialUpdate(int id, ItemDTO dto) {
		Integer entityId = id;
		logger.debug("partialUpdate({}, {})", entityId, dto);
		Optional<Item> optionalEntity = repository.findById(entityId);
		if (optionalEntity.isPresent()) {
			Item entity = optionalEntity.get();
			// implement here the partial update
			// entity.setXxx(dto.getXxx());
			// etc ...
			repository.save(entity);
			return true; // find and updated
		} else {
			return false; // not found (not updated)
		}
	}

	/**
	 * Creates the given entity
	 *
	 * @param dto
	 * @return true if created, false if already exists
	 */
	public boolean create(ItemDTO dto) {
		logger.debug("create({})", dto);
		// auto-generated Primary Key
		repository.save(dtoToEntity(dto));
		return true; // always created
	}

	/**
	 * Deletes an entity by its PK
	 *
	 * @param id 
	 * @return true if deleted, false if not found
	 */
	public boolean deleteById(int id) {
		Integer entityId = id;
		logger.debug("deleteById({})", entityId);
		if (repository.existsById(entityId)) {
			repository.deleteById(entityId);
			return true; // find and deleted
		} else {
			return false; // not found (not deleted)
		}
	}

	// -----------------------------------------------------------------------------------------
	// Specific "finders"
	// -----------------------------------------------------------------------------------------
/***
	public List<ItemDTO> findByTitle(String title) {
		logger.debug("findByTitle({})", title);
		// List<Item> list = repository.findByTitle(title);
		List<Item> list = repository.findByTitleContaining(title);
		return entityListToDtoList(list);
	}

	public List<ItemDTO> findByPrice(BigDecimal price) {
		logger.debug("findByPrice({})", price);
		// List<Item> list = repository.findByTitle(title);
		List<Item> list = repository.findByPrice(price);
		return entityListToDtoList(list);
	}

	public List<ItemDTO> findByTitleAndPrice(String title, BigDecimal price) {
		logger.debug("findByTitleAndPrice({}, {})", title, price);
		List<Item> list = repository.findByTitleContainingAndPrice(title, price);
		return entityListToDtoList(list);
	}
***/
}
