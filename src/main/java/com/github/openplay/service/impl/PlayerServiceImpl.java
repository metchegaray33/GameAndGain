package com.github.openplay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.CampaingsHasUsersInterface;
import com.github.openplay.model.UsersReceivesBadgesInterface;
import com.github.openplay.model.impl.CampaignsHasUsers;
import com.github.openplay.model.impl.UsersReceivesBadges;
import com.github.openplay.repository.CampaignsHasUsersRepository;
import com.github.openplay.repository.UsersReceivesBadgesRepository;
import com.github.openplay.service.PlayerService;


@Service("playerService")
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	private CampaignsHasUsersRepository campaignsHasUsersRepository;
	
	@Autowired
	private UsersReceivesBadgesRepository usersReceivesBadgesRepository;
	
//	@Autowired
//	private BadgeRepository badgeRepository;
	
	@Transactional
	public CampaingsHasUsersInterface save(CampaingsHasUsersInterface campaign) {
		return campaignsHasUsersRepository.save((CampaignsHasUsers) campaign);
	}
		
	@Transactional
	public UsersReceivesBadgesInterface save(UsersReceivesBadgesInterface badge) {
		return usersReceivesBadgesRepository.save((UsersReceivesBadges) badge);
	}
	
//	public int findByBadgeId(int value){
//		BadgeInterface badge = badgeRepository.findByBadgeId(findByBadgeId);
//		return badgeRepository.save
//	}
//	
}
