package com.bah.reinvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/activities/")
public class ActivityController {

//    @Autowired
//    private ActivityRepository activityRepository;

    @GetMapping()
    public void getActivities()
    {
        // TODO: RETURN LIST OF ACTIVITIES
    }

    @GetMapping(value="/{id}")
    public void getActivity(@PathVariable String id)
    {
        // TODO: RETURN Specified Activity
        // activityRepo.findActivityById(id);
    }
}
