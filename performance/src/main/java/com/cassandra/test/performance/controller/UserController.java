package com.cassandra.test.performance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cassandra.test.performance.service.UserServiceImpl;
import com.cassandra.test.performance.table.User;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User users =userServiceImpl.createUser(user);
        return new ResponseEntity<User>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/readall") 
    public ResponseEntity<List<User>> readAll() {
        List<User> Users = userServiceImpl.readAll();
        return new ResponseEntity<List<User>>(Users, HttpStatus.OK);
    }
    
    @GetMapping(value = "/read/{id}") 
    public ResponseEntity<User> read(@PathVariable String id) {
        User user2 = userServiceImpl.readOne(id);
        System.out.println("changes");
        return new ResponseEntity<User>(user2, HttpStatus.OK);

    }
    
   

    @DeleteMapping("/delete") 
    public ResponseEntity<List<User>> delete(@RequestParam("id") String Id) {
        System.out.println("inside Deleted");
    	List<User> list = userServiceImpl.delete(Id);
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

}

