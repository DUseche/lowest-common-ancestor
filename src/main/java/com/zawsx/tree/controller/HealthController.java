package com.zawsx.tree.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by David Useche on 3/09/2019.
 *
 * Checks if the MS is ok
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    /**
     * Retrieves the current state of the microservice
     * @return the current status of service
     */
    @GetMapping
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok().build();
    }
}
