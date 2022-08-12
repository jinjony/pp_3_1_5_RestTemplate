package com.example.pp_3_1_5resttemplate.controllers;


import com.example.pp_3_1_5resttemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Connection {

    static final String URL = "http://94.198.50.185:7081/api/users";


    RestTemplate restTemplate = new RestTemplate();
    private List<String> cookies;




    public void getUsers () {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        cookies = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class).getHeaders().get("Set-Cookie");
    }

    public String createUser (User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));
        HttpEntity<User> entity = new HttpEntity<User>(user,headers);
        return restTemplate.exchange(URL, HttpMethod.POST, entity, String.class).getBody();
    }

    public String updateUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));
        HttpEntity<User> entity = new HttpEntity<User>(user,headers);

        return restTemplate.exchange(URL, HttpMethod.PUT, entity, String.class).getBody();
    }

    public String deleteUser(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));
        HttpEntity<User> entity = new HttpEntity<User>(headers);

        return restTemplate.exchange(
                URL+"/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }







}
