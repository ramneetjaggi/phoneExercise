package com.cisco.phone.repository;

import com.cisco.phone.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


public interface PhoneRepository extends JpaRepository<Phone, UUID> {

    @Query(value = "SELECT * FROM phones_cisco WHERE user_id = ?1", nativeQuery = true)
    List<Phone> findByUserId(UUID userID);

    void deleteById( UUID phoneID);
}
