package com.example.day3;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    ArrayList<Tracker> trackers = new ArrayList<Tracker>();


    @GetMapping("/get")
    public ArrayList<Tracker> getTracker() {
        return trackers;
    }

    @PostMapping("/add")
    public ApiResponse addTracker(@RequestBody Tracker tracker) {
        trackers.add(tracker);
        return new ApiResponse("Add!");
    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTracker(@PathVariable int index) {
        trackers.remove(index);
        return new ApiResponse("Delete!");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTracker(@PathVariable int index, @RequestBody Tracker tracker) {
        trackers.set(index, tracker);
        return new ApiResponse ("Update done!");
    }

    @PutMapping("/change/{index}")
    public ApiResponse change(@PathVariable int index, @RequestBody Tracker tracker) {
        trackers.get(index).setStatus(tracker.getStatus());
        return new ApiResponse("Change done!");

    }

    @GetMapping("/search")
    public String search(@RequestBody Tracker tracker) {
        for (int i = 0; i < trackers.size(); i++) {
            if (trackers.get(i).title.equals(tracker.getTitle()))
                return trackers.get(i).title;
        }
        return "you can found it!";

    }
}