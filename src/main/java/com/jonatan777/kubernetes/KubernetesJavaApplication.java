package com.jonatan777.kubernetes;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jonatan777.kubernetes.domain.User;
import com.jonatan777.kubernetes.persistence.UserRepository;
import com.jonatan777.kubernetes.service.UserService;



@SpringBootApplication
public class KubernetesJavaApplication {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(KubernetesJavaApplication.class, args);
    }

    @PostConstruct
    public void checkIfWorks() {

        repository.deleteAll();

        service.create(new User("Minikube",
                LocalDate.of(2006, 10, 01)));
        service.create(new User("Kubectl",
                LocalDate.of(1999, 05, 15)));

        List<User> findAll = service.findAll();
        for (User user : findAll) {
            System.out.println(user.getId() + ":" + user.getName());
        }

    }

}
