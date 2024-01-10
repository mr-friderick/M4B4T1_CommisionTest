fun main() {
    println("Ваша комиссия составляет: ${calculateCommission(cardType = "Мир", 75001, 5000)}")
}

fun calculateCommission(cardType: String = "VK Pay", monthlyAmount: Int = 0, amount: Int): Int {
    val limitM                = 75000
    val commissionPercentageM = 0.006
    val commissionAddM        = 20
    val commissionPercentageV = 0.0075
    val minCommissionV        = 35

    return when {
        (cardType == "Mastercard" || cardType == "Maestro") && monthlyAmount > limitM -> (amount * commissionPercentageM).toInt() + commissionAddM
        (cardType == "Visa" || cardType == "Мир") -> if ((amount * commissionPercentageV) < minCommissionV) {
            minCommissionV
        } else {
            (amount * commissionPercentageV).toInt()
        }
        else -> 0
    }
}