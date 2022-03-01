var scan = java.util.Scanner(System.`in`)

var sumMastercard: Long = 0
var sumMaestro: Long = 0
var sumVisa: Long = 0
var sumMir: Long = 0
var sumVkPay: Long = 0
fun main() {
    while (true) {
        println(
            "Выберите способ перевода (введите порядковый номер): " + "\n" +
                    "1 Mastercard" + "\n" +
                    "2 Maestro" + "\n" +
                    "3 Visa" + "\n" +
                    "4 Мир" + "\n" +
                    "5 VK Pay"
        )
        val typeOfCardUerChoice = scan.nextInt()

        println("Введите сумму перевода в копейках")
        val sumTransfer = scan.nextLong()


        val typeOfCard = when (typeOfCardUerChoice) {
            1 -> "Mastercard"
            2 -> "Maestro"
            3 -> "Visa"
            4 -> "Mir"
            5 -> "VK Pay"
            else -> "VK Pay"
        }
        if (!isAvailableLimits(typeOfCard, sumPreviousTransfer(typeOfCard), sumTransfer)) {
            println("Превышен лимит на перевод")
            continue
        }

        val totalCommission = calculateCommission(typeOfCard, sumPreviousTransfer(typeOfCard), sumTransfer)

        println("Комиссия: $totalCommission копеек")

        sumPreviousAfterTransfer(typeOfCard, sumTransfer)
    }
}

fun sumPreviousTransfer(typeOfCard: String): Long {
    return when (typeOfCard) {
        "Mastercard" -> sumMastercard
        "Maestro" -> sumMaestro
        "Visa" -> sumVisa
        "Mir" -> sumMir
        "VK Pay" -> sumVkPay
        else -> sumVkPay

    }
}

fun sumPreviousAfterTransfer(typeOfCard: String, sumTransfer: Long) {
    when (typeOfCard) {
        "Mastercard" -> sumMastercard += sumTransfer
        "Maestro" -> sumMaestro += sumTransfer
        "Visa" -> sumVisa += sumTransfer
        "Mir" -> sumMir += sumTransfer
        "VK Pay" -> sumVkPay += sumTransfer
        else -> sumVkPay += sumTransfer
    }
    println(
        "Mastercard = $sumMastercard" + "\n" +
                "Maestro = $sumMaestro" + "\n" +
                "Visa = $sumVisa" + "\n" +
                "Мир = $sumMir" + "\n" +
                "VK Pay = $sumVkPay"
    )
}


fun calculateCommission(typeOfCard: String, sumPreviousTransfer: Long, sumTransfer: Long): Double {
    return when (typeOfCard) {
        "Mastercard" -> calculateMastercardMaestro(sumPreviousTransfer, sumTransfer)
        "Maestro" -> calculateMastercardMaestro(sumPreviousTransfer, sumTransfer)
        "Visa" -> calculateVisaMir(sumTransfer)
        "Mir" -> calculateVisaMir(sumTransfer)
        "VK Pay" -> 0.0
        else -> 0.0
    }
}

fun calculateMastercardMaestro(sumPreviousTransfer: Long, sumTransfer: Long): Double {
    val maxTransfer = 75_000_00
    val commissionPercent = 0.006
    val commissionConstant = 20_00
    return when (sumPreviousTransfer + sumTransfer) {
        in 0..maxTransfer -> 0.0
        else -> sumTransfer * commissionPercent + commissionConstant
    }
}

fun calculateVisaMir(sumTransfer: Long): Double {
    val commissionPercent = 0.0075
    val commissionConstant = 35_00
    return sumTransfer * commissionPercent + commissionConstant
}


fun isAvailableLimits(typeOfCard: String, sumPreviousTransfer: Long, sumTransfer: Long): Boolean {
    val limitOfCards = 600_000_00
    val limitVkPayDay = 40_000_00
    val limitVkPay = 15_000_00
    return when (typeOfCard) {
        "VK Pay" -> {
            when {
                (sumPreviousTransfer + sumTransfer) <= limitVkPayDay && sumTransfer <= limitVkPay -> true
                else -> false
            }
        }
        else -> {
            when {
                (sumPreviousTransfer + sumTransfer) <= limitOfCards -> true
                else -> false
            }
        }
    }
}
