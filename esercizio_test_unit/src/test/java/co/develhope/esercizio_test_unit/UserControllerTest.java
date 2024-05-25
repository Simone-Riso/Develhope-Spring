package co.develhope.esercizio_test_unit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.develhope.esercizio_test_unit.controller.UserController;
import co.develhope.esercizio_test_unit.entity.User;
import co.develhope.esercizio_test_unit.service.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class UserControllerTest {

	@Mock
	private UserService userServiceMock;

	@InjectMocks
	private UserController userController;

	private User testUser;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		testUser = new User(1L, "Simone", "Riso", 22, "simonrice@example.com");
	}

	@Test
	public void testGetAllUsers() {
		List<User> userList = new ArrayList<>();
		userList.add(testUser);

		when(userServiceMock.getAllUsers()).thenReturn(userList);

		List<User> result = userController.getAllUsers();

		assertEquals(1, result.size());
		assertEquals(testUser, result.get(0));
	}

	@Test
	public void testGetUserById() {
		when(userServiceMock.findUser(1L)).thenReturn(Optional.of(testUser));

		ResponseEntity<User> responseEntity = userController.getUserById(1L);

		assertEquals(testUser, responseEntity.getBody());
	}

	@Test
	public void testGetUserById_UserNotFound() {
		when(userServiceMock.findUser(2L)).thenReturn(Optional.empty());

		ResponseEntity<User> responseEntity = userController.getUserById(2L);

		assertEquals(404, responseEntity.getStatusCodeValue());
	}

	@Test
	public void testCreateUser() {
		when(userServiceMock.createUser(testUser)).thenReturn(testUser);

		ResponseEntity<User> responseEntity = userController.createUser(testUser);

		assertEquals(testUser, responseEntity.getBody());
	}

	@Test
	public void testUpdateUser() {
		when(userServiceMock.updateUser(1L, testUser)).thenReturn(testUser);

		ResponseEntity<User> responseEntity = userController.updateUser(1L, testUser);

		assertEquals(testUser, responseEntity.getBody());
	}

	@Test
	public void testDeleteUser() {
		when(userServiceMock.deleteUser(1L)).thenReturn(true);

		ResponseEntity<User> responseEntity = userController.deleteUser(1L);

		assertEquals(204, responseEntity.getStatusCodeValue());
	}

	@Test
	public void testDeleteUser_UserNotFound() {
		when(userServiceMock.deleteUser(2L)).thenReturn(false);

		ResponseEntity<User> responseEntity = userController.deleteUser(2L);

		assertEquals(404, responseEntity.getStatusCodeValue());
	}
}
