/**
 * 
 */
package com.intellect.test.user_cud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.intellect.test.user_cud.entity.User;

/**
 * @author admin
 *
 */
public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long>{
	@Query("SELECT u FROM User u where email=:email and isActive = true")
	public User findByEmail(@Param("email") String email);
}
