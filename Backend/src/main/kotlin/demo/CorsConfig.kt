package demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.*

@Configuration
class CorsConfig {

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        // This line is crucial for allowing requests from the frontend.
        // It tells the browser that requests from http://localhost:3000 are allowed.
        config.allowedOrigins = Arrays.asList("http://localhost:3000", "http://frontend:3000")
        config.allowedMethods = Arrays.asList("GET")

        // This allows all headers
        config.allowedHeaders = Arrays.asList("*")

        // This allows credentials like cookies, authorization headers, etc.
        config.allowCredentials = true

        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}
