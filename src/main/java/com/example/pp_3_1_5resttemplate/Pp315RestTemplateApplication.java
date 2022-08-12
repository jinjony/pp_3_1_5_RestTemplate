package com.example.pp_3_1_5resttemplate;

import com.example.pp_3_1_5resttemplate.controllers.Connection;
import com.example.pp_3_1_5resttemplate.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class Pp315RestTemplateApplication {

    static Connection connection = new Connection();

    public static void main(String[] args) {
        SpringApplication.run(Pp315RestTemplateApplication.class, args);

        connection.getUsers();

        User user = new User(3L, "James", "Brown", (byte)20);
        System.out.println(connection.createUser(user));
        user.setName("Thomas");
        user.setLastName("Shelby");
        System.out.println(connection.updateUser(user));
        System.out.println(connection.deleteUser(3L));

    }


}
