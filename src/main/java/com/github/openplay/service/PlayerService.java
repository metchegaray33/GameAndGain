package com.github.openplay.service;

import com.github.openplay.model.CampaingsHasUsersInterface;
import com.github.openplay.model.UsersReceivesBadgesInterface;

public interface PlayerService {
	CampaingsHasUsersInterface save(CampaingsHasUsersInterface campaign);
	
	UsersReceivesBadgesInterface save(UsersReceivesBadgesInterface badge);
}
