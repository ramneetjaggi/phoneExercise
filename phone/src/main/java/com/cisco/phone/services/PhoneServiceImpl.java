package com.cisco.phone.services;

import com.cisco.phone.models.Phone;
import com.cisco.phone.repository.PhoneRepository;
import com.cisco.phone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public  class PhoneServiceImpl implements PhoneService {

    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public  Phone addUserPhoneByID(Phone createPhone, UUID userId){

        createPhone.setUser(userRepository.getById(userId));
        return phoneRepository.save(createPhone);
    };

    @Override
    public  void deleteByUserPhone(UUID userID,UUID phoneID){
        if (userRepository.existsById(userID)) {
            phoneRepository.deleteById(phoneID);
        }
    }

    @Override
    public  List<Phone> getAllUsersPhone(UUID userID){
        List<Phone> phones = new ArrayList<>();
        if (userRepository.existsById(userID)) {
            phones = phoneRepository.findByUserId(userID);

        }
        return phones;
    }
}
