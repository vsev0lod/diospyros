package com.diospyros.uplift.repositories;

import com.diospyros.uplift.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
