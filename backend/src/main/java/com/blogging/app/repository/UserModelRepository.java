package com.blogging.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.app.models.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByName(String userEmail);
}
