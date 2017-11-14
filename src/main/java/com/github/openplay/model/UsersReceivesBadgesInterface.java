package com.github.openplay.model;

import com.github.openplay.model.impl.Badge;
import com.github.openplay.model.impl.User;

public interface UsersReceivesBadgesInterface {

	public Integer getIdUsers_Receives_Badges();

	public void setIdUsers_Receives_Badges(Integer idUsers_Receives_Badges);

	public User getUser();

	public void setUser(User user);

	public Badge getBadge();
	
	public void setBadge(Badge badge);
	
	public int getValue();

	public void setValue(int value);
}
