package com.naveen.quizapp;

import com.naveen.quizapp.controller.CountriesController;
import com.naveen.quizapp.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class QuizappApplicationTests {

	@Mock
	private CountryService countryService;

	@InjectMocks
	private CountriesController countryController;

	@BeforeEach
	void setMockOutput() {
		when(countryService.getWelcomeMessage()).thenReturn("Hello Mockito Test Dheeraj");
	}


	@Test
	public void shouldReturnDefaultMessage() {
		String response = countryController.greeting();
		assertThat(response).isEqualTo("Hello Mockito Test");
	}
}

