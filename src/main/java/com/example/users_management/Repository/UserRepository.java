package com.example.users_management.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.users_management.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
