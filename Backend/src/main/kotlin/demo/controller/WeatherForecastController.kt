import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.LocalDate
import java.util.*

@RestController
@RequestMapping("/")
class NumberController {

    private val summaries = arrayOf(
        "Freezing", "Bracing", "Chilly", "Cool", "Mild",
        "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    )

    private val random = Random()

    @GetMapping("/weatherforecast")
    fun getWeatherForecast(): List<WeatherForecast> {
        val forecasts = mutableListOf<WeatherForecast>()
        for (index in 0..5) {
            val tmpDate = Calendar.getInstance()
            tmpDate.add(Calendar.DAY_OF_MONTH, 1)
            forecasts += WeatherForecast(
                date = tmpDate.toString(),
                temperatureC = random.nextInt(50) - 10,
                summary = summaries[random.nextInt(summaries.size)]
            )
        }
        return forecasts
    }

    data class WeatherForecast(
        var date: String,
        var temperatureC: Int,
        var summary: String?
    ) {

        var temperatureF: Int

        init {
            temperatureF = 32 + (temperatureC / 0.5556).toInt()
        }
    }
}