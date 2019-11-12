package com.tutorial.docker.springboot.dockerspringboot.controller;

import com.tutorial.docker.springboot.dockerspringboot.Exceptions.ResourceNotFoundException;
import com.tutorial.docker.springboot.dockerspringboot.model.VisitorEntity;
import com.tutorial.docker.springboot.dockerspringboot.repository.VisitorEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/visitors")
public class VisitorEntityRestController {

    @Autowired
    private VisitorEntityRepository visitorEntityRepository;

    @GetMapping
    public Page<VisitorEntity> getQuestions(Pageable pageable) {
        return visitorEntityRepository.findAll(pageable);
    }


    @PostMapping
    public VisitorEntity createQuestion(@Valid @RequestBody VisitorEntity visitor) {
        return visitorEntityRepository.save(visitor);
    }

    @PutMapping("/{visitorId}")
    public VisitorEntity updateQuestion(@PathVariable Long visitorId,
                                   @Valid @RequestBody VisitorEntity visitorRequest) {
        return visitorEntityRepository.findById(visitorId)
                .map(visitor -> {
                    visitor.setName(visitorRequest.getName());
                    return visitorEntityRepository.save(visitor);
                }).orElseThrow(() -> new ResourceNotFoundException("Visitor not found with id " + visitorId));
    }


    @DeleteMapping("/{visitorId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long visitorId) {
        return visitorEntityRepository.findById(visitorId)
                .map(visitor -> {
                    visitorEntityRepository.delete(visitor);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Visitor not found with id " + visitorId));
    }
}
