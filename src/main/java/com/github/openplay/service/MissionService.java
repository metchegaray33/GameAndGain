package com.github.openplay.service;

import java.util.List;

import com.github.openplay.model.impl.Mission;

public interface MissionService {
	public void createMission(Mission mission);
	public Mission getMission(int id);
	public List<Mission> getAllMissions();
	public void editMission(Mission mission);
	public void deleteMission(int id);
}
