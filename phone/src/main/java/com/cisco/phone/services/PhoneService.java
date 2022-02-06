/* Copyright

 */
package com.cisco.phone.services;

import com.cisco.phone.models.Phone;

import java.util.List;
import java.util.UUID;

/**
 * Phone Service that adds, deletes and gets al user phones
 */

public interface PhoneService {

    /**
     * @param phoneID
     * @param userID
     */
    public void deleteByUserPhone(UUID phoneID, UUID userID);

    /**
     * @param userID
     * @return
     */
    public List<Phone> getAllUsersPhone(UUID userID);

    /**
     * @param createPhone
     * @param userID
     * @return
     */
    public Phone addUserPhoneByID(Phone createPhone, UUID userID);
}
