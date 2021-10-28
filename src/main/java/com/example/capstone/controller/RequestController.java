package com.example.capstone.controller;

import com.example.capstone.model.Request;
import com.example.capstone.service.RequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RequestController {

    private final RequestService service;

    public RequestController(RequestService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/requests")
    List<Request> getAllRequests() {
        return service.getAllRequests();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/requests")
    Request save(@RequestBody Request request) {
        return service.postRequest(request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/requests")
    void deleteRecord(@RequestParam Long id) {
        service.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/requests/{id}")
    Optional<Request> getSingleRequest(@RequestParam Long id) {
        return service.getSingleRequest(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/requests")
    void updateAPhoneNumber(@RequestParam Long id, @RequestParam String phone) {
        service.updatePhone(id, phone);
    }


}
