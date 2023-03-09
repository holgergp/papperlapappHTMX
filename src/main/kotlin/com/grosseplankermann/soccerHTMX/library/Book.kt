package com.grosseplankermann.soccerHTMX.library

data class Book(val title: String, val isbn: ISBN, val author: String) {
    fun getCoverURLSmall(): String {
        return "https://covers.openlibrary.org/b/isbn/%s-S.jpg".format(isbn)
    }
    fun getCoverURLMedium(): String {
        return "https://covers.openlibrary.org/b/isbn/%s-M.jpg".format(isbn)
    }
}

data class ISBN(val number: String) : Comparable<ISBN> {
    override fun compareTo(other: ISBN): Int {
        return Comparator.comparing(ISBN::number).compare(this, other)
    }

    override fun toString(): String {
        return number
    }

}
