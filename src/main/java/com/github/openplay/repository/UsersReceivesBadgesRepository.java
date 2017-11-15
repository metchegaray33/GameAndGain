package com.github.openplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.impl.UsersReceivesBadges;

@Repository("usersReceivesBadgesRepository")
public interface UsersReceivesBadgesRepository extends JpaRepository<UsersReceivesBadges, Integer> {
	
//	@Query("select c from Badge c where c.badgeId = :idBadge")
//	UsersReceivesBadges findById(@Param("idBadge") int idBadge);
}
