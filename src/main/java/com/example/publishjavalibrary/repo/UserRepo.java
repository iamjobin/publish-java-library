package com.example.publishjavalibrary.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.example.publishjavalibrary.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Long> {

    @Query(value = "SELECT * FROM user", nativeQuery = true )
    List<User> getAllUser(List<User> user);

    @Query(value = "SELECT * FROM User ud WHERE ud.id=?1", countQuery ="SELECT count(*) FROM Users WHERE id=?1", nativeQuery = true)
    Optional<User> getOneUser(Integer id);

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    Page<User> findByName(String name, Pageable pageable);

}
