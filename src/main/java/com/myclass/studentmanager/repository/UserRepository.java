package com.myclass.studentmanager.repository;

import com.myclass.studentmanager.dto.UserDto;
import com.myclass.studentmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT new com.myclass.studentmanager.dto.UserDto(u.id, u.email, u.password, u.fullName, u.avatar, r.name) FROM User u JOIN u.role r WHERE u.email= :email")
    UserDto findByEmail(@Param("email") String email);
}
