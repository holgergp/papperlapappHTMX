package com.grosseplankermann.soccerHTMX.form

import io.github.wimdeblauwe.hsbt.mvc.HtmxRequest
import io.github.wimdeblauwe.hsbt.mvc.HxRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.server.ResponseStatusException

@Controller
@RequestMapping("/form")
class FormHtmxController() {
    @GetMapping("/") // Only called on a full page refresh, not an htmx request
    fun indexRequest(model: Model): String? {
        model.addAttribute("form", OutgoingFormData(""))
        return "form"
    }

    @PostMapping("/saveForm")
    @HxRequest
    fun saveForm(formData: IncomingFormData, details: HtmxRequest?, model: Model): String? {
        model.addAttribute("form", OutgoingFormData(formData.title, "Save Successful"))
        return "formFragments :: formInput"
    }

    @PostMapping("/validateForm")
    @HxRequest
    fun validateForm(formData: IncomingFormData, details: HtmxRequest?, model: Model): String? {
        model.addAttribute("form", OutgoingFormData(formData.title, "Validating"))
        Thread.sleep(2000)
        return "formFragments :: formInput"
    }

    @PostMapping("/throwError")
    @HxRequest
    fun throwError(formData: IncomingFormData, details: HtmxRequest?, model: Model): String? {
        throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Something is wrong"
        )
    }
}
