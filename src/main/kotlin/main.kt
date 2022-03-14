fun main() {
    println(agoToText(30))
    println(agoToText(61))
    println(agoToText(hoursInSeconds(11)))
    println(agoToText(hoursInSeconds(25)))
    println(agoToText(hoursInSeconds(24 * 3)))
    println(agoToText(hoursInSeconds(24 * 4)))
}

fun agoToText(secondsAgo: Int): String {
    val result = when (secondsAgo) {
        in 0..60 -> "только что."
        in 61..3600 -> xMinutes(secondsAgo)
        in 3601..86400 -> xHours(secondsAgo)
        in 86401..172800 -> "сегодня."
        in 172801..259200 -> "вчера."
        else -> "давно."
    }
    return "Был(а) в сети $result"
}

fun xMinutes(secondsAgo: Int): String {
    val minutes = (secondsAgo / 60)
    val remainderOfDivision = minutes % 10
    return when {
        remainderOfDivision == 1 && minutes != 11 -> "$minutes минуту назад."
        minutes in 11..14 -> "$minutes минут назад."
        remainderOfDivision in 2..4 -> "$minutes минуты назад."
        else -> "$minutes минут назад."
    }
}

fun xHours(secondsAgo: Int): String {
    val hour = secondsAgo / 3600
    val remainderOfDivision = hour % 10
    return when {
        remainderOfDivision == 1 && hour != 11 -> "$hour час назад."
        hour in 10..20 -> "$hour часов назад."
        remainderOfDivision in 2..4 -> "$hour часа назад."
        else -> "$hour часов назад."
    }
}

fun hoursInSeconds(hour: Int): Int {
    return hour * 3600
}

fun minutesInSeconds(minutes: Int): Int {
    return minutes * 60
}