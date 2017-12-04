package com.github.openplay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.CommentInterface;
import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.Comment;
import com.github.openplay.model.impl.User;
import com.github.openplay.repository.AdminRepository;
import com.github.openplay.repository.CommentRepository;
import com.github.openplay.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements  AdminService {

	@Autowired
	private AdminRepository adminRepository;
	private CommentRepository commentRepository;
	
	@Transactional
	public UserInterface save(UserInterface user) {
		return adminRepository.save((User)user);
	}
	
	public CommentInterface saveComment(CommentInterface comment) {
		return commentRepository.save((Comment)comment);
	}

	public boolean findByLogin(String userName, String password) {	
		UserInterface usr = adminRepository.findByUserName(userName);
		
		if(usr != null && usr.getPassword().equals(password)) {
			return true;
		} 
		
		return false;		
	}

	public boolean findByUserName(String userName) {
		UserInterface usr = adminRepository.findByUserName(userName);
		
		if(usr != null) {
			return true;
		}
		
		return false;
	}

	}
