package com.example.rd.airquality;

import com.example.rd.airquality.service.AirQualityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AirQualityServiceTest {
    private AirQualityService airQualityService;

    @BeforeEach
    public void setUp(){
        airQualityService = new AirQualityService();
    }

    @Test
    @DisplayName("testAirQualityServiceBasic")
    public void testAirQualityServiceBasic() throws IOException {
        // 테스트 실행(메서드 호출)
        String result = airQualityService.getAirQualityDataBasic("서울");

        // 결과 검즘 > 결과값이 null 인지 확인
        assertNotNull(result); // 응답이 Null인지 여부 확인
        assertFalse(result.isEmpty()); // 응답이 비었는지 여부 확인

        // json 응답이 유효한지 여부 확인.(예외가 발생하는지 아닌지)
        // 즉, 올바른 json 형태의 데이터인지 확인
        assertDoesNotThrow(() -> new ObjectMapper().readTree(result));

    }
}
