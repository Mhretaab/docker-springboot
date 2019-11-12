package com.tutorial.docker.springboot.dockerspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaAuditing
public class DockerSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerSpringbootApplication.class, args);
    }

}
