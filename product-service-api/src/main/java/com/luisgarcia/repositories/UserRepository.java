package com.luisgarcia.repositories;

import com.luisgarcia.repositories.entities.ProductEntity;
import com.luisgarcia.repositories.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
