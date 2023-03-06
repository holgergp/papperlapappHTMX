package com.grosseplankermann.soccerHTMX.library;

import org.springframework.stereotype.Repository;

@Repository
class BookRepository(
    val books: MutableList<Book> = mutableListOf(
        Book("The Art of Agile Development", ISBN("9781492080695"), "James Shore"),
        Book("Don't Make Me Think", ISBN("9780321344755"), "Steve Krug"),
        Book("Das gewünschteste Wunschkind aller Zeiten treibt mich in den Wahnsinn", ISBN("9783407864222"), " Danielle Graf, Katja Seide"),
    )
) {

    fun getAll() = books

    fun add(book: Book) {
        books.add(book)
    }

    fun findByISBN(isbn: ISBN): Book? {
        return books.find { it.isbn == isbn }
    }

}
