package com.example.quickstart;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    List<Job> findAll();
    void createJob(Job job);

    Job findById(Long id);

    boolean deleteById(Long id);
}
