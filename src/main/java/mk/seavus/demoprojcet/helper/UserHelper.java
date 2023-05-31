package mk.seavus.demoprojcet.helper;

import mk.seavus.demoprojcet.entity.User;
import mk.seavus.model.UserDto;

public class UserHelper {

	private UserHelper() {}
	
	public static User fillUser(UserDto userDto) {
		return User.builder()
				.id(userDto.getId())
				.userName(userDto.getUsername())
				.firstName(userDto.getFirstName())
				.lastName(userDto.getLastName())
				.email(userDto.getLastName())
				.password(userDto.getPassword())
				.phone(userDto.getPhone())
				.userStatus(userDto.getUserStatus())
				.build();
	}
	
	public static UserDto fillUserDto(User user) {
		return UserDto.builder()
				.id(user.getId())
				.username(user.getUserName())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.password(user.getPassword())
				.phone(user.getPhone())
				.userStatus(user.getUserStatus())
				.build();
	}
	
	public static void updateUser(UserDto userDto, User user) {
		user.setFirstName(userDto.getFirstName() != null ? userDto.getFirstName() : user.getFirstName());
		user.setLastName(userDto.getLastName() != null ? userDto.getLastName() : user.getLastName());
		user.setEmail(userDto.getEmail() != null ? userDto.getEmail() : user.getEmail());
		user.setPassword(userDto.getPassword() != null ? userDto.getPassword() : user.getPassword());
		user.setPhone(userDto.getPhone() != null ? userDto.getPhone() : user.getPhone());
		user.setUserStatus(userDto.getUserStatus() != null ? userDto.getUserStatus() : user.getUserStatus());
	}
}
