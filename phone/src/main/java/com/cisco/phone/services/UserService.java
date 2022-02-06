/* Copyright

 */
package com.cisco.phone.services;
import com.cisco.phone.models.User;

import java.util.List;
import java.util.UUID;

/**
 * User Service that adds, deletes and gets al user phones
 */

public interface UserService {

    /**
     * @param createUser
     * @return
     * @throws Exception
     */
    public User createUser(User createUser) throws Exception;

    /**
     * @param id
     */
    public void deleteByUserId(UUID id);

    /**
     * @param completeInfo
     * @return
     */
    public List<User> getAllUsers(boolean completeInfo);

    public  User findByID(UUID id);

    public User updateUserPrefPhone(UUID userID, User updateUser);
}
