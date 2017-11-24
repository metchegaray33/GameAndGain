package com.github.openplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.impl.Campaign;

@Repository("campaignRepository")
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
	
	@Query("select c from Campaign c where c.name = :campaign")
	Campaign findByName(@Param("campaign") String campaign);
	
	@Query("select c from Campaign c where c.campaignsId = :id")
	Campaign findById(@Param("id") int id);

}
