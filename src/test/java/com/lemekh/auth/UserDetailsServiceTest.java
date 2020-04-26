package com.lemekh.auth;

import com.lemekh.auth.service.UserDetailsServiceImpl;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserDetailsServiceTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private BCryptPasswordEncoder encoder;

    @Test
    public void loadUserByUserName__userNotFound() {
        final String username = "test";
        Mockito.when(encoder.encode(anyString())).thenReturn("12345");
        Assertions.assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(username));
    }

    @Test
    public void loadUserByUserName__userExists() {
        final String username = "omar";
        Mockito.when(encoder.encode(anyString())).thenReturn("12345");
        Asserts.notNull(userDetailsService.loadUserByUsername(username), "User found");
    }
}
