package com.grosseplankermann.soccerHTMX.form

import io.github.wimdeblauwe.hsbt.mvc.HtmxRequest
import io.github.wimdeblauwe.hsbt.mvc.HxRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class FormHtmxController() {
    @GetMapping("/form") // Only called on a full page refresh, not an htmx request
    fun indexRequest(model: Model): String? {
        model.addAttribute("form", FormModel(""))
        return "form"
    }

    @PostMapping("/saveForm")
    @HxRequest
    fun saveForm(formData: FormData, details: HtmxRequest?, model: Model): String? {
        model.addAttribute("form", FormModel(formData.title, "Save Successful"))
        return "fragments :: formInput"
    }

    @PostMapping("/validateForm")
    @HxRequest
    fun validateForm(formData: FormData, details: HtmxRequest?, model: Model): String? {
        model.addAttribute("form", FormModel(formData.title, "Validating"))
        return "fragments :: formInput"
    }
}
