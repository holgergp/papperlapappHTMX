package com.grosseplankermann.soccerHTMX.library

import io.github.wimdeblauwe.hsbt.mvc.HxRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/books")
class BookController(val repository: BookRepository) {

    @GetMapping // Only called on a full page refresh, not an htmx request
    fun all(model: Model): String? {
        model.addAttribute("books", repository.getAll())
        return "books"
    }

    @GetMapping("/{isbn}") // Only called on a full page refresh, not an htmx request
    fun one(@PathVariable isbn: ISBN, model: Model): String? {
        model.addAttribute("book", repository.findByISBN(isbn))
        return "book"
    }

    @GetMapping("/{isbn}")
    @HxRequest
    fun oneHtmx(@PathVariable isbn: ISBN, model: Model): String? {
        model.addAttribute("book", repository.findByISBN(isbn))
        return "book :: book-details"
    }

}
