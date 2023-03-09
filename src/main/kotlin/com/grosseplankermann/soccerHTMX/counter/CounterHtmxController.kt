package com.grosseplankermann.soccerHTMX.counter

import io.github.wimdeblauwe.hsbt.mvc.HtmxRequest
import io.github.wimdeblauwe.hsbt.mvc.HxRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/counter")
class CounterHtmxController(val repository: CounterHtmxRepository) {
    @GetMapping("/") // Only called on a full page refresh, not an htmx request
    fun indexRequest(model: Model): String? {
        model.addAttribute("counter", repository.getDatabaseContents())
        return "counter"
    }

    @PostMapping("/increment")
    @HxRequest
    fun increment(details: HtmxRequest?, model: Model): String? {
        val counter = repository.storeIncrement()
        model.addAttribute("counter", counter)
        return "counterFragments :: counterResultFragment"
    }

    @PostMapping("/decrement")
    @HxRequest
    fun decrement(details: HtmxRequest?, model: Model): String? {
        val counter = repository.storeDecrement()
        model.addAttribute("counter", counter)
        return "counterFragments :: counterResultFragment"
    }
}
