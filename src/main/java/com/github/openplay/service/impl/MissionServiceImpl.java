package com.github.openplay.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.Interest;
import com.github.openplay.model.impl.Mission;
import com.github.openplay.model.impl.Difficulties;
import com.github.openplay.service.MissionService;

//@Resource
@Service
@Transactional
@Component
public class MissionServiceImpl implements MissionService {
	
//	private static final Class<Interest> Interest = null;
//	private static final Class<User> User = null;
	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public void createMission(Mission mission) {
		// TODO Auto-generated method stub
		Difficulties difficulty=entityManager.getReference(Difficulties.class, mission.difficulty.difficultyId);
		Campaign campaign = entityManager.getReference(Campaign.class, mission.campaign.campaignsId);
		Interest interest = entityManager.getReference(Interest.class, mission.interest.interestId);
		Mission missionAdded = new Mission();
		missionAdded.setDifficulty(difficulty);
		missionAdded.setCampaign(campaign);
		missionAdded.setInterest(interest);
		missionAdded.setScore(mission.score);
		missionAdded.setName(mission.name);
		missionAdded.setDescription(mission.description);
		entityManager.persist(missionAdded);
	}

	@Override
	public Mission getMission(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Mission.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mission> getAllMissions() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select mission from Mission mission").getResultList();
	}

	@Override
	public void editMission(Mission mission) {
		Mission MissionEdit = entityManager.getReference(Mission.class, mission.missionId);
		MissionEdit.setName(mission.name);
		MissionEdit.setDescription(mission.description);
		MissionEdit.setScore(mission.score);
		Difficulties difficulty=entityManager.getReference(Difficulties.class, mission.difficulty.difficultyId);
		Campaign campaign =entityManager.getReference(Campaign.class, mission.campaign.campaignsId);
		MissionEdit.setDifficulty(difficulty);
		MissionEdit.setCampaign(campaign);
		
		entityManager.merge(MissionEdit);

	}

	@Override
	public void deleteMission(int id) {
		Mission c = entityManager.find(Mission.class, id);
		entityManager.remove(c);

	}

}
