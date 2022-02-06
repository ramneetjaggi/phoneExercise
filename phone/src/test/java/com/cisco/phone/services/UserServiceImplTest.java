package com.cisco.phone.services;

import com.cisco.phone.models.User;
import com.cisco.phone.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.when;

import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userServiceImplTest;

    @Mock
    UserRepository userRepository;

    private User testUser;

    @Before
    public void setup(){
        testUser= new User();
        UUID uuid = UUID.randomUUID();
        testUser.setUserId(uuid);
        testUser.setEmailAddress("emailAddress");
        when(userRepository.save(testUser)).thenReturn(testUser);
    }

    @Test
    public void createUserTest(){
        //Act
        User createdUser=userServiceImplTest.createUser(testUser);
        //Assert
        assertNotNull(createdUser);
    }

    @Test
    public void getUsersTest(){
        //Creating methods to be tested as a part of this file

    }

    @Test
    public void deleteByUserIdTest(){
        //Creating methods to be tested as a part of this file

    }
}
