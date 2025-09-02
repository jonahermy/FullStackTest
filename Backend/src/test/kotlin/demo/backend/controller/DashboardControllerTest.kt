package demo.backend.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import com.fasterxml.jackson.databind.ObjectMapper
import demo.controller.DashboardController
import org.junit.jupiter.api.Assertions

@WebMvcTest(DashboardController::class)
class DashboardControllerTest(@Autowired private val mockMvc: MockMvc) {

    private val objectMapper = ObjectMapper()

    @Test
    fun dashboardControllerTest() {
        val result = mockMvc.get("/dashboard")
            .andExpect {
                status { isOk() }
            }.andReturn()

        val jsonString = result.response.contentAsString
        val resultArray = objectMapper.readValue(jsonString, Array::class.java)

        Assertions.assertEquals(5, resultArray.size)
        for (entry in resultArray) {
            Assertions.assertInstanceOf(Integer::class.java, entry)
            Assertions.assertTrue(entry as Integer > 0)
        }
    }
}
