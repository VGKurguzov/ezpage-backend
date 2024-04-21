package com.saxakiil.ezpage.repository;

import java.util.List;
import java.util.Optional;

import com.saxakiil.ezpage.entity.Page;
import com.saxakiil.ezpage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, String> {

    @Query("SELECT p FROM Page p JOIN FETCH p.user WHERE p.user = :user")
    List<Page> findAllByUser(User user);

    @Query("SELECT p FROM Page p JOIN FETCH p.user WHERE p.user = :user AND p.id = :id")
    Optional<Page> findByUserAndId(User user, String id);
}