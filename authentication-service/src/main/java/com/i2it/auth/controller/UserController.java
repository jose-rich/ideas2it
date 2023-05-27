package com.i2it.auth.controller;

import com.i2it.auth.dto.PaginatedUserResponse;
import com.i2it.auth.dto.UserDto;
import com.i2it.auth.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CRUD REST APIs for User Resource",description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	/*@PostMapping("/")
	public UserDto addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}*/

	@Operation(summary = "Get All Users REST API",description = "Get All Users REST API is used to get a all the users from the database")
	@ApiResponse(responseCode = "200",description = "HTTP Status 200 SUCCESS")
	@GetMapping("/")
	@PreAuthorize("hasAuthority('read')")
	public PaginatedUserResponse getAllUsers(Pageable pageable) {
		return userService.getAllUsers(pageable);
	}

	@Operation(summary = "Get User By ID REST API",description = "Get User By ID REST API is used to get a single user from the database")
	@ApiResponse(responseCode = "200",description = "HTTP Status 200 SUCCESS")
	@GetMapping("/{userId}")
	@PreAuthorize("hasAuthority('read')")
	public UserDto getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}

	/*@GetMapping("/role/{roleId}")
	public List<UserDto> getUserByRoleId(@PathVariable long roleId) {
		return userService.getUserByRoleId(roleId);
	}*/

	@Operation(summary = "Delete User REST API",description = "Delete User REST API is used to delete a particular user from the database")
	@ApiResponse(responseCode = "200",description = "HTTP Status 200 SUCCESS")
	@DeleteMapping("/{userId}")
	@PreAuthorize("hasAuthority('delete')")
	public String deleteById(@PathVariable Integer userId) {
		return userService.deleteById(userId);
	}

	@Operation(summary = "Update User REST API",description = "Update User REST API is used to update a particular user in the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
	@PutMapping("/")
	@PreAuthorize("hasAuthority('update')")
	public UserDto updateUser(@RequestBody UserDto userDto) {
		return userService.updateUser(userDto);
	}

}
