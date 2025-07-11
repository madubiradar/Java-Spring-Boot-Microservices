package com.example.quickstart.job;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    List<Job> findAll();
    void createJob(Job job);

    Job findById(Long id);

    boolean deleteById(Long id);

    Boolean updateJob(Long id, Job job);
}
