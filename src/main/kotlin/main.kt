fun main() {
    /*
    Был уверен, что лимиты в задачу не входят, т.к. речь только о комиссии.
    Тогда, если я правильно понимаю суть задачи, то:
    при превышении лимита, мы не считаем комиссию и соответственно программа завершает работу
    */
    val monthlyAmount = 1
    val amount        = 15001
    val cardType      = "VK Pay"

    when (limitExceeded(cardType, monthlyAmount, amount)) {
        true -> println("Превышен лимит переводов")
        else -> println("Ваша комиссия составляет: ${calculateCommission(cardType, monthlyAmount, amount)}")
    }
}

fun limitExceeded(cardType: String = "VK Pay", monthlyAmount: Int = 0, amount: Int): Boolean {
    val limitDayV   = 15000
    val limitMonthV = 40000
    val limitDayA   = 150000
    val limitMonthA = 600000

    return when {
        cardType == "VK Pay" && ((monthlyAmount + amount > limitMonthV) || amount > limitDayV) -> true
        // можно было и в первое выражение вставить (под первое true) через ИЛИ, но для читаемости решил вынести отдельно
        (monthlyAmount + amount > limitMonthA) || amount > limitDayA -> true
        else -> false
    }
}

fun calculateCommission(cardType: String = "VK Pay", monthlyAmount: Int = 0, amount: Int): Int {
    val limitM                = 75000
    val commissionPercentageM = 0.006
    val commissionAddM        = 20
    val commissionPercentageV = 0.0075
    val minCommissionV        = 35

    return when {
        (cardType == "Mastercard" || cardType == "Maestro") && monthlyAmount > limitM + amount -> (amount * commissionPercentageM).toInt() + commissionAddM
        (cardType == "Visa" || cardType == "Мир") -> if ((amount * commissionPercentageV) < minCommissionV) {
            minCommissionV
        } else {
            (amount * commissionPercentageV).toInt()
        }
        else -> 0
    }
}