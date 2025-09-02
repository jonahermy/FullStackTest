package demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/")
class WeatherForecastController {

    private val summaries = arrayOf(
        "Freezing", "Bracing", "Chilly", "Cool", "Mild",
        "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    )

    private val random = Random()

    @GetMapping("/weatherforecast")
    fun getWeatherForecast(): List<WeatherForecast> {
        val forecasts = mutableListOf<WeatherForecast>()
        for (index in 1..5) {
            forecasts += WeatherForecast(
                date = LocalDateTime.now().plusDays(index.toLong()),
                temperatureC = random.nextInt(50) - 10,
                summary = summaries[random.nextInt(summaries.size)]
            )
        }
        return forecasts
    }

    class WeatherForecast(
        var date: LocalDateTime,
        var temperatureC: Int,
        var summary: String?
    ) {

        private constructor() : this(LocalDateTime.now(), 0, null)

        var temperatureF: Int

        init {
            temperatureF = 32 + (temperatureC / 0.5556).toInt()
        }
    }
}