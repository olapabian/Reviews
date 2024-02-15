package com.example.Reviews.ServicesTests;

import com.example.Reviews.Model.MyUser;
import com.example.Reviews.Model.MyUserDTO;
import com.example.Reviews.Repositories.MyUserRepository;
import com.example.Reviews.Services.RegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class RegistrationServiceTest {

    @Mock
    private MyUserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private RegistrationService registrationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterNewUser_Success() {
        // Arrange
        MyUserDTO userDTO = new MyUserDTO("testUser", "password");
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        // Act
        boolean result = registrationService.registerNewUser(userDTO, mock(Model.class));

        // Assert
        assertTrue(result);
        verify(userRepository, times(1)).save(any(MyUser.class));
    }

}
