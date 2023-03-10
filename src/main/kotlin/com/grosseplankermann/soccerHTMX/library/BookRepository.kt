package com.grosseplankermann.soccerHTMX.library;

import org.springframework.stereotype.Repository;

@Repository
class BookRepository(
    val books: MutableList<Book> = mutableListOf(
        Book("JavaScript: The Good Parts", ISBN("9780596517748"), "Douglas Crockford"),
        Book("The Art of Agile Development", ISBN("9780596527679"), "James Shore"),
        Book("Don't Make Me Think", ISBN("9780321344755"), "Steve Krug"),
        Book("Das gewünschteste Wunschkind aller Zeiten treibt mich in den Wahnsinn", ISBN("9783407864222"), " Danielle Graf, Katja Seide"),
    )
) {

    fun getAll(): MutableList<Book> = books.stream().sorted(Comparator.comparing(Book::isbn)).toList()

    fun add(book: Book) {
        books.add(book)
    }

    fun findByISBN(isbn: ISBN): Book? {
        return books.find { it.isbn == isbn }
    }

    fun update(isbn: ISBN, book: Book) {
        val existing = findByISBN(isbn)
        books.remove(existing)
        add(book)
    }

    fun delete(isbn: ISBN) {
        books.remove(findByISBN(isbn))
    }

}
