package demo.backend.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import demo.controller.WeatherForecastController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.time.LocalDateTime

@WebMvcTest(WeatherForecastController::class)
class WeatherForecastControllerTest(@Autowired private val mockMvc: MockMvc) {

    private val objectMapper = ObjectMapper().registerModule(JavaTimeModule())

    @Test
    fun weatherForecastControllerTest() {
        val result = mockMvc.get("/weatherforecast")
            .andExpect {
                status { isOk() }
            }.andReturn()

        val jsonString = result.response.contentAsString
        val resultArray = objectMapper.readValue(jsonString, Array<WeatherForecastController.WeatherForecast>::class.java)

        val now = LocalDateTime.now()
        Assertions.assertEquals(5, resultArray.size)
        for (forecastEntry in resultArray) {
            // forecast should always be in future
            Assertions.assertTrue(forecastEntry.date.isAfter(now))
            // Fahrenheit is always greater than Celsius
            Assertions.assertTrue(forecastEntry.temperatureC < forecastEntry.temperatureF)
        }
    }

}