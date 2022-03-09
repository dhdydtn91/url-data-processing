package com.api.urldataprocessing.controller;

import com.api.urldataprocessing.dto.RequestUrlDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class UrlDataProcessingController {

    @GetMapping("/urlDataProcessing")
    public ResponseEntity urlDataProcessing(@RequestBody @Valid RequestUrlDataDto requestUrlData) {

        return ResponseEntity.ok().build();
    }

}
