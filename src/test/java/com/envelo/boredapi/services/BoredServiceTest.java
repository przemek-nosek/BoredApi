package com.envelo.boredapi.services;

import com.envelo.boredapi.model.Activity;
import com.envelo.boredapi.repositories.BoredRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class BoredServiceTest {

    @Mock
    private BoredRepository boredRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BoredService boredService;

    @Test
    void getRandomActivity_shouldReturnActivity_whenActivityIsUnique() {
        //given
        Activity activity = new Activity("activity", "type", 10, 10, "link", "key", 15.0, null);
        given(restTemplate.getForEntity(anyString(), any())).willReturn(ResponseEntity.of(Optional.of(activity)));
        given(boredRepository.existsById(anyString())).willReturn(false);

        //when
        Activity randomActivity = boredService.getRandomActivity();

        //then
        assertThat(randomActivity).isNotNull();
        then(restTemplate).should().getForEntity(anyString(), any());
        then(boredRepository).should().existsById(anyString());
    }

    @Test
    void getRandomActivity_shouldThrowRuntimeException_whenCouldNotConnectToApi() {
        //given
        given(restTemplate.getForEntity(anyString(), any())).willReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

        //when
        //then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> boredService.getRandomActivity())
                .withMessage("Could not connect to the API.");

    }
}