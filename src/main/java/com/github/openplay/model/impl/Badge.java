package com.github.openplay.model.impl;

import com.github.openplay.model.BadgeInterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;






import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;



@Component
@XmlRootElement(name="badges")
@Entity
@Table(name="badges")
public class Badge implements BadgeInterface{
	@Id
	@GeneratedValue
	private int badgeId;
	
	@NotEmpty
	private String name;
	
	
	@NotNull
	private int value;

	public int getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(int badgeId) {
		this.badgeId = badgeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}