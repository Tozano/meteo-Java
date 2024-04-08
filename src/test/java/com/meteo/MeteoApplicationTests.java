package com.meteo;

import com.meteo.models.Selection;
import com.meteo.models.User;
import com.meteo.repositories.SelectionRepository;
import com.meteo.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MeteoApplicationTests {
	@InjectMocks
	public MeteoService meteoService; // pour injecter mocks en dessous
	@Mock
	public UserRepository userRepository;
	@Mock
	public SelectionRepository selectionRepository;

	@BeforeEach
	void setup() {
		meteoService = new MeteoService(userRepository, selectionRepository);
	}

	@Test
	void findAllUsers_Test() {
		//GIVEN -> qu'est ce que je donne
		List<User> userList = new ArrayList<>();

		Mockito.when(userRepository.findAll()).thenReturn(userList); // quand on fait appelle à la fonction, on retourne cette valeur

		//WHEN -> ligne
		List<User> result = meteoService.getAllUsers();

		//THEN -> vérif
		Assertions.assertNotNull(result);
		verify(userRepository).findAll(); // check si on appelle bien la méthode 1 fois (valeur par défaut)
		verifyNoMoreInteractions(userRepository); // check si on appelle bien le repo 1 fois (valeur par défaut)
	}

	@Test
	void findUser_Test() {
		//GIVEN -> qu'est ce que je donne
		User user = new User();

		Mockito.when(userRepository.findById(anyInt())).thenReturn(Optional.of(user)); // quand on fait appelle à la fonction, on retourne cette valeur

		//WHEN -> ligne
		User result = meteoService.getUser(anyInt());

		//THEN -> vérif
		Assertions.assertNotNull(result);
		verify(userRepository).findById(anyInt()); // check si on appelle bien la méthode 1 fois (valeur par défaut)
		verifyNoMoreInteractions(userRepository); // check si on appelle bien le repo 1 fois (valeur par défaut)
	}

	@Test
	void findAllSelections_Test() {
		//GIVEN -> qu'est ce que je donne
		List<Selection> selectionList = new ArrayList<>();

		Mockito.when(selectionRepository.findAll()).thenReturn(selectionList); // quand on fait appelle à la fonction, on retourne cette valeur
		// si type void : doNothing().when()...

		//WHEN -> ligne
		List<Selection> result = selectionRepository.findAll();

		//THEN -> vérif
		Assertions.assertNotNull(result);
		verify(selectionRepository).findAll(); // check si on appelle bien la méthode 1 fois (valeur par défaut)
		verifyNoMoreInteractions(selectionRepository); // check si on appelle bien le repo 1 fois (valeur par défaut)
	}

	@Test
	void findAllSelectionByUser_Test() {
		//GIVEN
		User user = new User();
		List<Selection> selectionList = new ArrayList<>();

		Mockito.when(selectionRepository.findAllByUser(user)).thenReturn(selectionList);

		//WHEN
		List<Selection> result = selectionRepository.findAllByUser(user);

		//THEN
		Assertions.assertNotNull(result);
		verify(selectionRepository).findAllByUser(user);
		verifyNoMoreInteractions(selectionRepository);
	}

	@Test
	void getAndShowAllUsersWithSelections_Test() {
		//GIVEN
		User user = new User(1L, "Toto", "Tanguy", "Ozano", "fr");
		Selection selection = new Selection(1L, "Test 1", "", "", "", 22, 83, false, false, false, false, user);
		List<Selection> selectionList = new ArrayList<>();
		selectionList.add(selection);
		List<User> userList = new ArrayList<User>();
		userList.add(user);

		when(userRepository.findAll()).thenReturn(userList);
		when(selectionRepository.findAllByUser(any())).thenReturn(selectionList);

		//doNothing().when(meteoService).getAndShowAllUsersWithSelections();

		//WHEN
		meteoService.getAndShowAllUsersWithSelections();

		//THEN
		verify(userRepository).findAll();
		verify(selectionRepository).findAllByUser(user);
		verifyNoMoreInteractions(userRepository);
		verifyNoMoreInteractions(selectionRepository);
	}
}
