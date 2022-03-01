var scan = java.util.Scanner(System.`in`)

var sumMastercard: Long = 0
var sumMaestro: Long = 0
var sumVisa: Long = 0
var sumMir: Long = 0
var sumVkPay: Long = 0
fun main() {

    //  var sumPreviousTransfer: Long = 0

    while (true) {
        println(
            "Выберите способ перевода: " + "\n" +
                    "1 Mastercard" + "\n" +
                    "2 Maestro" + "\n" +
                    "3 Visa" + "\n" +
                    "4 Мир" + "\n" +
                    "5 VK Pay"
        )
        val typeOfCardUerChoice = scan.nextInt()

        println("Введите сумму перевода")
        var sumTransfer = scan.nextLong()


        var typeOfCard = when (typeOfCardUerChoice) {
            1 -> "Mastercard"
            2 -> "Maestro"
            3 -> "Visa"
            4 -> "Мир"
            5 -> "VK Pay"
            else -> "VK Pay"
        }
        if (isAvailableLimits(typeOfCard, sumPreviousTransfer(typeOfCard), sumTransfer)) {

        } else {
            println("Превышен лимит на перевод")
            continue
        }

        val totalCommission = calculateCommission(typeOfCard, sumPreviousTransfer(typeOfCard), sumTransfer)


    }
}

fun sumPreviousTransfer(typeOfCard: String): Long {
    return when (typeOfCard) {
        "Mastercard" -> sumMastercard
        "Maestro" -> sumMaestro
        "Visa" -> sumVisa
        "Мир" -> sumMir
        "VK Pay" -> sumVkPay
        else -> sumVkPay

    }
}


fun calculateCommission(typeOfCard: String, sumPreviousTransfer: Long, sumTransfer: Long) {
    when (typeOfCard) {
        "Mastercard" -> calculateMastercardMaestro(sumPreviousTransfer, sumTransfer)
        "Maestro" -> calculateMastercardMaestro(sumPreviousTransfer, sumTransfer)
        "Visa" -> calculateVisaMir(sumTransfer)
        "Mir" -> calculateVisaMir(sumTransfer)
        "VK Pay" -> 0.0
        else -> 0.0
    }
}

fun calculateMastercardMaestro(sumPreviousTransfer: Long, sumTransfer: Long): Double {
    return when (sumPreviousTransfer + sumTransfer) {
        in 0..75_000_00 -> 0.0
        else -> sumTransfer * 0.006 + 20_00
    }
}

fun calculateVisaMir(sumTransfer: Long): Double {
    return sumTransfer * 0.0075 + 35_00
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
