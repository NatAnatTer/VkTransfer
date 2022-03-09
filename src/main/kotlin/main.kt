import java.nio.charset.Charset

//var scan = java.util.Scanner(System.`in`)

//var sumMastercard: Long = 0
//var sumMaestro: Long = 0
//var sumVisa: Long = 0
//var sumMir: Long = 0
//var sumVkPay: Long = 0
fun main() {
    var sumMastercard: Int = 0
    var sumMaestro: Int = 0
    var sumVisa: Int = 0
    var sumMir: Int = 0
    var sumVkPay: Int = 0

    var typeOfCard = "Vk Pay"

    while (true) {
        println(
            "Выберите способ перевода (введите порядковый номер): " + "\n" +
                    "1 Mastercard" + "\n" +
                    "2 Maestro" + "\n" +
                    "3 Visa" + "\n" +
                    "4 Мир" + "\n" +
                    "5 VK Pay" + "\n" +
                    "6 End"

        )
        val typeOfCardUerChoice = readline()!!.toInt() //can.nextInt()

        println("Введите сумму перевода в копейках")
        val sumTransfer = readline()  //scan.nextLong()


        typeOfCard = when (typeOfCardUerChoice) {
            1 -> "Mastercard"
            2 -> "Maestro"
            3 -> "Visa"
            4 -> "Mir"
            5 -> "VK Pay"
            6 -> break
            else -> "не правильный ввод"
        }
        if (!isAvailableLimits(
                typeOfCard,
                sumPreviousTransfer(typeOfCard, sumMastercard, sumMaestro, sumVisa, sumMir, sumVkPay),
                sumTransfer
            )
        ) {
            println("Превышен лимит на перевод")
            continue
        }

        val totalCommission = calculateCommission(typeOfCard, sumPreviousTransfer(typeOfCard), sumTransfer)

        println("Комиссия: $totalCommission копеек")

        sumPreviousAfterTransfer(typeOfCard, sumTransfer, sumMastercard, sumMaestro, sumVisa, sumMir, sumVkPay)
    }
}

//fun readLine(): String? = LineReader.readLine(System.`in`, Charset.defaultCharset())


fun sumPreviousTransfer(
    typeOfCard: String,
    sumMastercard: Int,
    sumMaestro: Int,
    sumVisa: Int,
    sumMir: Int,
    sumVkPay: Int
): Int {
    return when (typeOfCard) {
        "Mastercard" -> sumMastercard
        "Maestro" -> sumMaestro
        "Visa" -> sumVisa
        "Mir" -> sumMir
        "VK Pay" -> sumVkPay
        else -> 0

    }
}

fun sumPreviousAfterTransfer(
    typeOfCard: String,
    sumTransfer: Int,
    sumMastercard: Int,
    sumMaestro: Int,
    sumVisa: Int,
    sumMir: Int,
    sumVkPay: Int
) {
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


fun calculateCommission(typeOfCard: String, sumPreviousTransfer: Int, sumTransfer: Int): Double {
    return when (typeOfCard) {
        "Mastercard" -> calculateMastercardMaestro(sumPreviousTransfer, sumTransfer)
        "Maestro" -> calculateMastercardMaestro(sumPreviousTransfer, sumTransfer)
        "Visa" -> calculateVisaMir(sumTransfer)
        "Mir" -> calculateVisaMir(sumTransfer)
        "VK Pay" -> 0.0
        else -> 0.0
    }
}

fun calculateMastercardMaestro(sumPreviousTransfer: Int, sumTransfer: Int): Double {
    val maxTransfer = 75_000_00
    val commissionPercent = 0.006
    val commissionConstant = 20_00
    return when (sumPreviousTransfer + sumTransfer) {
        in 0..maxTransfer -> 0.0
        else -> sumTransfer * commissionPercent + commissionConstant
    }
}

fun calculateVisaMir(sumTransfer: Int): Double {
    val commissionPercent = 0.0075
    val commissionConstant = 35_00
    return sumTransfer * commissionPercent + commissionConstant
}


fun isAvailableLimits(typeOfCard: String, sumPreviousTransfer: Int, sumTransfer: Int): Boolean {
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
