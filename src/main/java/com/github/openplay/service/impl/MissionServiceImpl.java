package com.github.openplay.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.Mission;
import com.github.openplay.model.impl.Difficulties;
import com.github.openplay.service.MissionService;

public class MissionServiceImpl implements MissionService {
//	private static final Class<Interest> Interest = null;
//	private static final Class<User> User = null;
	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public void createMission(Mission mission) {
		// TODO Auto-generated method stub
		Difficulties difficulty=entityManager.getReference(Difficulties.class, mission.difficulty.difficultyId);
		Campaign campaign =entityManager.getReference(Campaign.class, mission.campaign.campaignsId);
		Mission MissionAdded = new Mission();
		MissionAdded.setDifficulty(difficulty);
		MissionAdded.setCampaign(campaign);
		MissionAdded.setScore(mission.score);
		MissionAdded.setName(mission.name);
		MissionAdded.setDescription(mission.description);
		entityManager.persist(MissionAdded);
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
