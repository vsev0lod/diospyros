/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.services;

import com.diospyros.uplift.dto.LocationDTO;
import com.diospyros.uplift.dto.NewTaskDTO;
import com.diospyros.uplift.dto.TaskDTO;
import com.diospyros.uplift.persistence.entities.Task;
import com.diospyros.uplift.persistence.repositories.TaskRepository;
import com.diospyros.uplift.services.commons.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * REST service for entity "Task" <br>
 * <p>
 * This service provides all the necessary operations required by the REST controller <br>
 *
 * @author Telosys
 */
@Service
public class TaskService extends GenericService<Task, TaskDTO> {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository repository; // injected by constructor

    /**
     * Constructor (usable for Dependency Injection)
     *
     * @param repository the repository to be injected
     */
    public TaskService(TaskRepository repository) {
        super(Task.class, TaskDTO.class);
        this.repository = repository;
    }

    /**
     * Returns the entity ID object from the given DTO
     *
     * @param dto
     * @return
     */
    private Integer getEntityId(TaskDTO dto) {
        return dto.getId();
    }

    /**
     * Finds all occurrences of the entity
     *
     * @return
     */
    public List<TaskDTO> findAll() {
        logger.debug("findAll()");
        Iterable<Task> all = repository.findAll();
        return entityListToDtoList(all);
    }

    /**
     * Finds the entity identified by the given PK
     *
     * @param id
     * @return the entity or null if not found
     */
    public TaskDTO findById(int id) {
        Integer entityId = id;
        logger.debug("findById({})", entityId);
        Optional<Task> optionalEntity = repository.findById(entityId);
        return entityToDto(optionalEntity);
    }

    /**
     * Saves the given entity with the given PK <br>
     * "UPSERT" operation (updated if it exists or created if it does not exist)
     *
     * @param id
     * @param dto
     */
    public void save(int id, TaskDTO dto) {
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
    public boolean update(TaskDTO dto) {
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
    public boolean partialUpdate(int id, TaskDTO dto) {
        Integer entityId = id;
        logger.debug("partialUpdate({}, {})", entityId, dto);
        Optional<Task> optionalEntity = repository.findById(entityId);
        if (optionalEntity.isPresent()) {
            Task entity = optionalEntity.get();
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
    public boolean create(NewTaskDTO dto) {
        logger.debug("create({})", dto);
        // auto-generated Primary Key
        repository.save(dtoToEntity(TaskDTO.builder()
                .title(dto.getTitle())
                .creatorId(dto.getCreatorId())
                .description(dto.getDescription())
                .location(LocationDTO.builder().decimalDegrees(dto.getLatitude() + "," + dto.getLongtitude()).build())
                .tag(dto.getTag())
                .taskType(dto.getTaskType())
                .reward(BigDecimal.valueOf(dto.getReward()))
                .createdAt(LocalDate.now()).build()));
        return true; // always created
    }

    public boolean create(TaskDTO dto) {
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
 public List<TaskDTO> findByTitle(String title) {
 logger.debug("findByTitle({})", title);
 // List<Task> list = repository.findByTitle(title);
 List<Task> list = repository.findByTitleContaining(title);
 return entityListToDtoList(list);
 }

 public List<TaskDTO> findByPrice(BigDecimal price) {
 logger.debug("findByPrice({})", price);
 // List<Task> list = repository.findByTitle(title);
 List<Task> list = repository.findByPrice(price);
 return entityListToDtoList(list);
 }

 public List<TaskDTO> findByTitleAndPrice(String title, BigDecimal price) {
 logger.debug("findByTitleAndPrice({}, {})", title, price);
 List<Task> list = repository.findByTitleContainingAndPrice(title, price);
 return entityListToDtoList(list);
 }
 ***/
}
