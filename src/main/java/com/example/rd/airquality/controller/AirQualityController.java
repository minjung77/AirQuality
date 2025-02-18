package com.example.rd.airquality.controller;

import com.example.rd.airquality.service.AirQualityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class AirQualityController {

    //생성자 주입 방식으로 서비스 객체 생성
    private final AirQualityService airQualityService;

    //AirQualityService 에 @Service를 안 적어서 인자 입력 시 오류 떳는데 왜 그런건지 모르겠다.
    public AirQualityController(AirQualityService airQualityService) {
        this.airQualityService = airQualityService;
    }

    @GetMapping("/basic")
    public String basic(Model moel) throws IOException {
        String result = airQualityService.getAirQualityDataBasic();
        moel.addAttribute("airQualityData", result);
        return "airQuality";
    }
}
