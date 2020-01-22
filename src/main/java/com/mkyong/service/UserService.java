package com.mkyong.service;

import java.util.List;

import com.mkyong.dto.UserProfileDTO;

public interface UserService {

	public boolean addUser(UserProfileDTO user);

	public List<UserProfileDTO> fetchAllUsers();

}
