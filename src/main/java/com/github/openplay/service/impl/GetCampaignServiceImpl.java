package com.github.openplay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.CampaignStates;
import com.github.openplay.repository.CampaignRepository;
import com.github.openplay.service.GetCampaignService;


@Service("getCampaignService")
public class GetCampaignServiceImpl implements GetCampaignService {
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	@Transactional
	public Campaign getCampaignId(String campaign) {
		Campaign cId  = campaignRepository.findByName(campaign);
		int id = cId.getId();
		
		return campaignRepository.findById(id);
	}

}
