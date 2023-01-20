package com.grosseplankermann.soccerHTMX

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PapperlapappHtmxController() {
    @GetMapping("/") // Only called on a full page refresh, not an htmx request
    fun indexRequest(): String? {
        return "index"
    }
}
