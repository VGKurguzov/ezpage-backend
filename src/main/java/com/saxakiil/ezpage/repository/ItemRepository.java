package com.saxakiil.ezpage.repository;

import java.util.Optional;

import com.saxakiil.ezpage.entity.Item;
import com.saxakiil.ezpage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    @Query("SELECT i FROM Item i JOIN FETCH i.page JOIN FETCH i.page.user WHERE i.page.user = :user AND i.id = :id")
    Optional<Item> findByUserAndId(User user, String id);
}