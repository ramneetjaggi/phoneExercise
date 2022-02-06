package com.cisco.phone.controllers;

import com.cisco.phone.models.Phone;
import com.cisco.phone.models.User;
import com.cisco.phone.repository.PhoneRepository;
import com.cisco.phone.services.PhoneService;
import com.cisco.phone.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class PhoneController {
    private static final String INCLUDE_COMPLETE_INFO ="include-complete-info" ;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private PhoneRepository phoneRepository;

    @ApiOperation("Create user phone by user id")
    @PostMapping("v1/user/{id}/phone")
    public ResponseEntity<Phone> createPhonePerUser(@PathVariable UUID id,
                                               @RequestBody Phone createPhone) throws Exception {

        Phone response= this.phoneService.addUserPhoneByID(createPhone,id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation("Delete user phone by user id and phone id")
    @DeleteMapping(value = "v1/user/{id}/phone/{phoneid}")
    public  ResponseEntity<?>  deleteUserPhone(@PathVariable UUID id,@PathVariable UUID phoneid) {
        ResponseEntity responseEntity;
        this.phoneService.deleteByUserPhone(id,phoneid);
        try {
             responseEntity = new ResponseEntity<String>("Phone for user Deleted", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Unable delete phone.User/Phone id not found ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation("Get all user phones by user id")
    @GetMapping(value="v1/user/{id}/phone")
    public ResponseEntity<List<Phone>> getAllUsersPhone(@PathVariable UUID id){
        List<Phone> response= this.phoneService.getAllUsersPhone(id);
        return new ResponseEntity<List<Phone>>(response, HttpStatus.OK);
    }
}
