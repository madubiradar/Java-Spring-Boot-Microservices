package com.example.quickstart.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findById(@PathVariable("id") Long id){
        Job job = jobService.findById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/job")
    public ResponseEntity addJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Boolean isDeleted = jobService.deleteById(id);
        if (isDeleted)
            return new ResponseEntity<>("Job Deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }

    //@PutMapping("/job/{id}")
    @RequestMapping(method = RequestMethod.PUT, value = "/job/{id}")
    public ResponseEntity<String> updateJob(@PathVariable("id") Long id, @RequestBody Job job ){
        Boolean updated = jobService.updateJob(id, job);
        if(updated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job Not Found", HttpStatus.NOT_FOUND);
    }
//    @PutMapping("/update")
//    public Job updateJob(){
//        Job job = jobs.get(1);
//        job.setLocation("Hyderbad");
//        jobs.remove(1);
//        jobs.add(job);
//        return job;
//    }



}
