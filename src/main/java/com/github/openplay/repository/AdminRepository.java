package com.github.openplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.Badge;
import com.github.openplay.model.impl.User;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.mail = :userName")
	UserInterface findByUserName(@Param("userName") String userName);
	
	@Query("select u from User u where u.userId = :userId")
	UserInterface findByUserId(@Param("userId") Integer userId);
	
	@Query("select i from User i where i.mail = :emailAddress")
	UserInterface findByUserRoleId(@Param("emailAddress") String emailAddress);
	
	@Query("select b from User b where b.userId = :id") 
	User showUser(@Param("id") int id);
	
	@Query("select b from User b where b.name like CONCAT('%',:search,'%') or b.lastname like CONCAT('%',:search,'%') or b.country like CONCAT('%',:search,'%') or b.mail like CONCAT('%',:search,'%')") 
	List<User> showSearchResult(@Param("search") String search);
	
}
