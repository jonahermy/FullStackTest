package demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/")
class DashboardController {

    private val random = Random()

    @GetMapping
    fun getRoot(): String {
        return "Welcome to the backend API! The server is running."
    }

    @GetMapping("/dashboard")
    fun getDashboard(): List<Int> {
        val testList = mutableListOf<Int>()
        var last = random.nextInt(100)
        for(i in 0 .. 4) {
            val next = if(i % 2 == 0) {
                last + ((random.nextInt(40) + 10) * last / 100)
            } else{
                last - ((random.nextInt(40) + 10) * last / 100)
            }
            last = next
            testList += next
        }

        return testList
    }
}