package com.envelo.boredapi.services;

import com.envelo.boredapi.model.Activity;
import com.envelo.boredapi.model.ActivityEntity;
import com.envelo.boredapi.repositories.BoredRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoredService {

    private final BoredRepository boredRepository;
    private final RestTemplate restTemplate;

    private final static String RANDOM_BORED_ACTIVITY_URL = "https://www.boredapi.com/api/activity";

    public Activity getRandomActivity() {
        log.info("getRandomActivity");
        ResponseEntity<Activity> response;
        Activity activity;
        boolean isExists;

        do {
            response = restTemplate.getForEntity(RANDOM_BORED_ACTIVITY_URL, Activity.class);

            HttpStatus statusCode = response.getStatusCode();
            if (statusCode != HttpStatus.OK) {
                log.error("Could not connect to the API. Response code {}", statusCode);
                throw new RuntimeException("Could not connect to the API.");
            }

            activity = response.getBody();
            isExists = checkIfActivityUnique(Objects.requireNonNull(activity).getKey());
            log.info("activity -> {}, isExists -> {}", activity, isExists);

        } while (isExists);

        boredRepository.save(new ActivityEntity(activity.getKey()));

        return activity;
    }

    private boolean checkIfActivityUnique(String key) {
        return boredRepository.existsById(key);
    }
}
