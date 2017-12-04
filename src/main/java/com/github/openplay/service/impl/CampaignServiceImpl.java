package com.github.openplay.service.impl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.CampaignStates;
import com.github.openplay.model.impl.CampaignTypes;
import com.github.openplay.model.impl.Project;
import com.github.openplay.service.CampaignService;
import com.github.openplay.model.impl.User;
import com.github.openplay.model.impl.Interest;


@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {

//	private static final Class<Interest> Interest = null;
//	private static final Class<User> User = null;
	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public void createCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		CampaignStates state=entityManager.getReference(CampaignStates.class, campaign.campaignState.campaign_StateId);
		CampaignTypes type=entityManager.getReference(CampaignTypes.class, campaign.campaignType.campaign_TypeId);
		Interest interests=entityManager.getReference(Interest.class, campaign.interest.interestId);
		User user=entityManager.getReference(User.class, campaign.users.userId);
		Project project=entityManager.getReference(Project.class, campaign.project.projectId);
		Campaign campaignAdded = new Campaign();
		campaignAdded.setCampaignState(state);
		campaignAdded.setCampaignType(type);
		campaignAdded.setInterest(interests);
		campaignAdded.setUser(user);
		campaignAdded.setProject(project);
		campaignAdded.setName(campaign.name);
		campaignAdded.setDescription(campaign.description);
		campaignAdded.setMaxScore(campaign.maxScore);
		campaignAdded.setStartDate(campaign.startDate);
		campaignAdded.setEndDate(campaign.endDate);
		entityManager.persist(campaignAdded);
	}

	@Override
	public Campaign getCampaign(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Campaign.class, id);
	}

	@Override
	public List<Campaign> getAllCampaigns() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select camp from Campaign camp").getResultList();
	}

	@Override
	public void editCampaign(Campaign campaign) {
		Campaign campaignEdit = entityManager.getReference(Campaign.class, campaign.campaignsId);
		campaignEdit.setName(campaign.name);
		campaignEdit.setDescription(campaign.description);
		campaignEdit.setStartDate(campaign.startDate);
		campaignEdit.setEndDate(campaign.endDate);
		
		
		CampaignStates state=entityManager.getReference(CampaignStates.class, 1);
		CampaignTypes type=entityManager.getReference(CampaignTypes.class, campaign.campaignType.campaign_TypeId);
		Interest interests=entityManager.getReference(Interest.class, campaign.interest.interestId);
		User user=entityManager.getReference(User.class, campaign.users.userId);
		
		campaignEdit.setCampaignState(state);
		campaignEdit.setCampaignType(type);
		campaignEdit.setInterest(interests);
		campaignEdit.setUser(user);
		
		entityManager.merge(campaignEdit);

	}

	@Override
	public void deleteCampaign(int id) {
		Campaign c = entityManager.find(Campaign.class, id);
		entityManager.remove(c);

	}

}
