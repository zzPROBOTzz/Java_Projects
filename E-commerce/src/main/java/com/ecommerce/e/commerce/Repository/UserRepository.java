/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.e.commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author meeth
 */
import com.ecommerce.e.commerce.Model.User;
public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByEmail(String email);
    User findByUsername(String username);
    User findByEmail(String email);
}
