package com.example.quickstart;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService{

    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }

    @Override
    public Job findById(Long id) {

        for(Job job : jobs){
            if(Objects.equals(job.getId(), id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        Iterator<Job> iterator = jobs.iterator();

        while(iterator.hasNext()){
            if(iterator.next().getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
