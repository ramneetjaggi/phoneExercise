package com.cisco.phone.services;


import com.cisco.phone.controllers.UserController;
import com.cisco.phone.models.User;
import com.cisco.phone.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionalException;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOG= LoggerFactory.getLogger(UserController.class);
    @Override
    public User createUser(User createUser) {
        LOG.info("Creating the user UserServiceImpl-createUser");
            return userRepository.save(createUser);
    }

    @Override
    public void deleteByUserId(UUID userId) {
        try {
            userRepository.deleteById(userId);
        }
        catch(TransactionalException trx)
        {
            LOG.error("Error deleting the user please check the entered id"+userId);
        }
    }

    @Override
    public List<User> getAllUsers(boolean completeInfo) {
        return userRepository.findAll();
    }
    @Override
    public User findByID(UUID userID){
        return userRepository.getById(userID);
    }

    @Override
    public User updateUserPrefPhone(UUID userID, User updateUser) {
        User user = userRepository.getById(userID);
        user.setPreferredPhoneNumber(updateUser.getPreferredPhoneNumber());
        return userRepository.save(user);
    }
}
