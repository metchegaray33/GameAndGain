package com.github.openplay.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.github.openplay.model.UsersReceivesBadgesInterface;

@Component
@XmlRootElement(name="users_receives_badges")
@Entity
@Table(name="users_receives_badges")

public class UsersReceivesBadges implements UsersReceivesBadgesInterface{

	@Id
	@GeneratedValue
	private Integer idUsers_Receives_Badges;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "users_UserId")
	private User user;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "badges_BadgeId")
	private Badge badge;
	
	@NotNull
	private int value;

	public Integer getIdUsers_Receives_Badges() {
		return idUsers_Receives_Badges;
	}

	public void setIdUsers_Receives_Badges(Integer idUsers_Receives_Badges) {
		this.idUsers_Receives_Badges = idUsers_Receives_Badges;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
