package com.mkyong.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.dto.UserProfileDTO;
import com.mkyong.model.User;
import com.mkyong.repository.UserRepository;
import com.mkyong.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean addUser(UserProfileDTO userprofile) {
		User user = new User();
		user.setUserId(userprofile.getUserId());
		user.setUsername(userprofile.getUsername());
		user.setEmail(userprofile.getEmail());
		user.setPassword(userprofile.getPassword());
		try {
			userRepository.insert(user);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public List<UserProfileDTO> fetchAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserProfileDTO> userprofileList = new ArrayList<>();

		userList.stream().forEach(user -> {
			UserProfileDTO userProfile = new UserProfileDTO();
			userProfile.setUsername(user.getUsername());
			userProfile.setEmail(user.getEmail());
			userProfile.setUserId(user.getUserId());
			userprofileList.add(userProfile);
		});
		return userprofileList;
	}

}
