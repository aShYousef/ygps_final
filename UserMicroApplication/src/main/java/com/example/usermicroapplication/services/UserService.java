package com.example.usermicroapplication.services;

import com.example.usermicroapplication.VO.Provider;
import com.example.usermicroapplication.models.ProviderDto;
import com.example.usermicroapplication.models.User;
import com.example.usermicroapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
    public User getItemById(Integer id) {
        return this.userRepository.findById(id).get();
    }
    public User AddUser(User user) {
        return this.userRepository.save(user);
    }
    public List<ProviderDto> searchForProviders(String city, String category) {
        String url = "http://localhost:9001/provider/city/" + city + "/category/" + category;

        // Use RestTemplate to call the Provider service and get the data as ProviderDto[]
        ProviderDto[] response = restTemplate.getForObject(url, ProviderDto[].class);

        if (response == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(response);
    }
}