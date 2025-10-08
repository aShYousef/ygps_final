package com.example.usermicroapplication.controllers;

import com.example.usermicroapplication.VO.Provider;
import com.example.usermicroapplication.VO.ResponseTemplateVO;
import com.example.usermicroapplication.models.ProviderDto;
import com.example.usermicroapplication.models.User;
import com.example.usermicroapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
        @Autowired
        private UserService userService;
        @GetMapping("/")
        public ResponseEntity<List<User>> showAllUser() {
            List<User> users =this.userService.getAllUsers();
            return  new ResponseEntity<>(users, HttpStatus.OK);
        }
        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable Integer id) {
            User retrievedUser = this.userService.getItemById(id);
            return new ResponseEntity<>(retrievedUser, HttpStatus.OK);
        }

    @GetMapping("/city/{city}/category/{category}")
    public ResponseEntity<ResponseTemplateVO> getProviderByProviderCityAndCategory(
            @PathVariable("city") String providerCity,
            @PathVariable ("category") String providerCategory) {

        List<ProviderDto> providerDtos = userService.searchForProviders(providerCity, providerCategory);

        // Create the response wrapper
        ResponseTemplateVO response = new ResponseTemplateVO(providerDtos);
        // Return the wrapped response
        return new ResponseEntity<>(response, HttpStatus.OK);    }

        @PostMapping("/add")
        public ResponseEntity<User> addUser(@RequestBody User user) {
            User newUser = this.userService.AddUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
}
