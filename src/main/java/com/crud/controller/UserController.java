package com.crud.controller;

import com.crud.entity.Cat;
import com.crud.entity.User;
import com.crud.service.CatService;
import com.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CatService catService;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private Environment env;
    
    @GetMapping("/userById/{userid}")
    public String userById(@PathVariable int userid) {
    	User user = userService.getUserById(userid);
    	if(user==null || user.getUserid()==0) {
    		user = new User();
    		user.setUserid(userid);
    		user.setCats(new ArrayList<Cat>());
    		userService.saveUser(user);
    		return "User created successfully";
    		
    	}
    	
    	return "User already exists";
    }
    
    @GetMapping("/collectRandomCat/{userid}")
    public String collectRandomCat(@PathVariable int userid) {
    	User user = userService.getUserById(userid);
    	if(user==null || user.getUserid()==0) {
    		user = new User();
    		user.setUserid(userid);
    		user.setCats(new ArrayList<Cat>());
    		userService.saveUser(user);
//    		return "User created successfully";
    		
    	}

    	Cat cat = restTemplate.getForObject(env.getProperty("cataas.service.url"), Cat.class);
    	cat.setUser(user);
    	cat.setUserid(user.getUserid());
    	catService.saveCat(cat);
    	user.getCats().add(cat);
    	userService.saveUser(user);
    	return "Cat saved successfully to the user";
    }
    
    @RequestMapping(value = "/findAllCatsByUserId/{userid}", produces = {"application/JSON"})
    @ResponseBody
    public List<Cat> findAllCatsByUserId(@PathVariable int userid) {
    	User user =userService.getUserById(userid); 
        return user.getCats();
    }
    
//    @GetMapping("/user/{name}")
//    public User findUserByName(@PathVariable String name) {
//        return service.getUserByName(name);
//    }

//    @PostMapping("/createUser")
//    public User createUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//
//    @PostMapping("/addUsers")
//    public List<User> addProducts(@RequestBody List<User> users) {
//        return userService.saveUsers(users);
//    }
//
//    @GetMapping("/users")
//    public List<User> findAllUsers() {
//        return userService.getUsers();
//    }

    

//    @PutMapping("/update")
//    public User updateUser(@RequestBody User user) {
//        return service.updateUser(user);
//    }

//    @DeleteMapping("/delete/{userid}")
//    public String deleteUser(@PathVariable int userid) {
//        return userService.deleteUser(userid);
//    }
}
