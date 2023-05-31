package mk.seavus.demoprojcet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mk.seavus.demoprojcet.entity.User;
import mk.seavus.demoprojcet.helper.UserHelper;
import mk.seavus.demoprojcet.repository.UserRepository;
import mk.seavus.demoprojcet.service.IUserService;
import mk.seavus.model.UserDto;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
	
	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void createUser(UserDto userDto) {
		try {
			repository.save(UserHelper.fillUser(userDto));
			log.info("User is stored");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void deleteUser(Long id) {
		try {
			repository.deleteById(id);
			log.info("User is deleted!");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}

	@Override
	public List<UserDto> getUsers() {
		List<UserDto> usersDto = new ArrayList<>();
		try {
			List<User> users = repository.findAll();
			users.stream().forEach(u -> {
				UserDto userDto = UserHelper.fillUserDto(u);
				usersDto.add(userDto);
			});
			log.info("All users are read");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return usersDto;
	}

	@Override
	public UserDto getUserById(Long id) {
		UserDto userDto = null;
		try {
			User user = repository.findById(id).orElseThrow();
			userDto = UserHelper.fillUserDto(user);
			log.info("User is read");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return userDto;
	}

	@Override
	public UserDto getUserByName(String userName) {
		UserDto userDto = null;
		try {
			User user = repository.findByUserName(userName).orElseThrow();
			userDto = UserHelper.fillUserDto(user);
			log.info("User is read");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return userDto;
	}

	@Override
	public void updateUser(Long id, UserDto userDto) {
		try {
			User user = repository.findById(id).orElseThrow();
			if (userDto.getId() != null || userDto.getUsername() != null)
				throw new Exception();
			UserHelper.updateUser(userDto, user);
			repository.save(user);
			log.info("User is updated");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}

}
