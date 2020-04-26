package com.lemekh.auth.service;

import org.apache.http.util.Asserts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserDetailsServiceTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private BCryptPasswordEncoder encoder;

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUserName__userNotFound() {
        final String username = "test";
        Mockito.when(encoder.encode(anyString())).thenReturn("12345");
        userDetailsService.loadUserByUsername(username);
    }

    @Test
    public void loadUserByUserName__userExists() {
        final String username = "omar";
        Mockito.when(encoder.encode(anyString())).thenReturn("12345");
        Asserts.notNull(userDetailsService.loadUserByUsername(username), "User found");
    }
}
