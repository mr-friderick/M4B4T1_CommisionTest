import org.junit.Test

import org.junit.Assert.*

class MainKtTest {
    /*
    Имеет ли здесь значение, что я не применяю явно методику ААА?
    Для проверки условий переобъявлять для каждой ветки значения переменных выглядит как-то перегружено.
    */

    @Test
    fun limitExceeded() {
        assertEquals(true,
            limitExceeded("VK Pay", 5000, 15001))

        assertEquals(true,
            limitExceeded("VK Pay", 40001, 2000))

        assertEquals(true,
            limitExceeded("VK Pay", 40001, 15001))

        assertEquals(false,
            limitExceeded("VK Pay", 1, 1))

        assertEquals(true,
            limitExceeded("Mastercard", 700000, 15000))

        assertEquals(true,
            limitExceeded("Maestro", 5000, 150001))

        assertEquals(false,
            limitExceeded("Mastercard", 5000, 15000))
    }

    @Test
    fun calculateCommission() {
        assertEquals(0,
            calculateCommission("VK Pay", 5000, 15001))

        assertEquals(35,
            calculateCommission("Visa", 0, 200))

        assertEquals(37,
            calculateCommission("Visa", 0, 5000))

        assertEquals(35,
            calculateCommission("Мир", 0, 200))

        assertEquals(37,
            calculateCommission("Мир", 0, 5000))

        assertEquals(80,
            calculateCommission("Mastercard", 70000, 10000))

        assertEquals(0,
            calculateCommission("Mastercard", 1, 1))

        assertEquals(80,
            calculateCommission("Maestro", 70000, 10000))

        assertEquals(0,
            calculateCommission("Maestro", 1, 1))
    }
}