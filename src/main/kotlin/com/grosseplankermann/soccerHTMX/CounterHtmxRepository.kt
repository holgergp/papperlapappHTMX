package com.grosseplankermann.soccerHTMX

import org.springframework.stereotype.Repository

val counter: Counter = Counter(0)
fun getInitialData(): Counter = counter

@Repository
class CounterHtmxRepository(var database: Counter = getInitialData()) {

    fun getDatabaseContents() = toUICounter(database)

    fun storeIncrement(): UICounter =
        toUICounter(incrementCounter().also { database = it })

    private fun incrementCounter(): Counter = Counter(getDatabaseContents().value + 1)

    fun storeDecrement(): UICounter =
        toUICounter(decrementCounter().also { database = it })

    private fun decrementCounter(): Counter = Counter(getDatabaseContents().value - 1)
}
