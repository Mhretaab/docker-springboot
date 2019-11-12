package com.tutorial.docker.springboot.dockerspringboot.repository;

import com.tutorial.docker.springboot.dockerspringboot.model.VisitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorEntityRepository extends JpaRepository<VisitorEntity, Long> {
}
