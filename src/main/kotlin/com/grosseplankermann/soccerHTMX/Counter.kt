package com.grosseplankermann.soccerHTMX

data class Counter(val value: Int)

data class UICounter(val value: Int, val isPositive: Boolean)

fun toUICounter(counter: Counter): UICounter = UICounter(counter.value, counter.value >= 0)
