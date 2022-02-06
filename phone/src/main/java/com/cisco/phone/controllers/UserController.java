package com.cisco.phone.controllers;



import com.cisco.phone.PhoneApplication;
import com.cisco.phone.models.User;
import com.cisco.phone.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private static final String INCLUDE_COMPLETE_INFO ="include-complete-info" ;

    private static final Logger LOG= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @PostMapping(value="v1/user")
    @ResponseBody
    public ResponseEntity<User> createUser(
            @Valid @RequestBody  User createUser) throws Exception {
        LOG.info("Creating the user");
        User response= this.userService.createUser(createUser);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "v1/user/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        ResponseEntity responseEntity;
        LOG.info("Deleting the user");
        this.userService.deleteByUserId(id);
        try {
            responseEntity = new ResponseEntity<String>("User Deleted", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Unable delete User.User id not found ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping(value="v1/users",params = {
            INCLUDE_COMPLETE_INFO
    })
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers
            (@RequestParam(value= INCLUDE_COMPLETE_INFO) boolean completeInfo){
        LOG.info("Listing all the user");
        List<User> response= this.userService.getAllUsers(completeInfo);
        return new ResponseEntity<List<User>>(response, HttpStatus.OK);
    }

}
