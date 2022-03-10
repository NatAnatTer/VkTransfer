fun main() {
    var sumMastercard: UInt = 0U
    var sumMaestro: UInt = 0U
    var sumVisa: UInt = 0U
    var sumMir: UInt = 0U
    var sumVkPay: UInt = 0U

    var typeOfCard: TypeOfCard

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
        val typeOfCardUerChoice = readLine()?.toUInt() ?: return
        if (typeOfCardUerChoice > 6U) {
            println("Введена не верная команда, повторите попытку снова")
            continue
        }


        typeOfCard = when (typeOfCardUerChoice) {
            1U -> TypeOfCard.MASTERCARD
            2U -> TypeOfCard.MAESTRO
            3U -> TypeOfCard.VISA
            4U -> TypeOfCard.MIR
            5U -> TypeOfCard.VK_PAY
            else -> break
        }

        print("Введите сумму перевода в копейках: ")
        val sumTransfer = readLine()?.toUInt() ?: return

        if (sumTransfer == 0U) {
            println("Введена не допустимая сумма")
            continue
        }
        val sumPrevious = sumPreviousTransfer(typeOfCard, sumMastercard, sumMaestro, sumVisa, sumMir, sumVkPay)
        if (!isAvailableLimits(
                typeOfCard,
                sumPrevious,
                sumTransfer
            )
        ) {
            println("Превышен лимит на перевод")
            continue
        }

        val totalCommission = calculateCommission(
            typeOfCard,
            sumPreviousTransfer(typeOfCard, sumMastercard, sumMaestro, sumVisa, sumMir, sumVkPay),
            sumTransfer
        )

        println("Комиссия: ${(totalCommission / 100U)} рублей ${totalCommission % 100U} копеек")

        when (typeOfCard) {
            TypeOfCard.MASTERCARD -> sumMastercard += sumTransfer
            TypeOfCard.MAESTRO -> sumMaestro += sumTransfer
            TypeOfCard.VISA -> sumVisa += sumTransfer
            TypeOfCard.MIR -> sumMir += sumTransfer
            TypeOfCard.VK_PAY -> sumVkPay += sumTransfer
        }
        println(
            "Mastercard = $sumMastercard" + "\n" +
                    "Maestro = $sumMaestro" + "\n" +
                    "Visa = $sumVisa" + "\n" +
                    "Мир = $sumMir" + "\n" +
                    "VK Pay = $sumVkPay"
        )
    }
}


fun sumPreviousTransfer(
    typeOfCard: TypeOfCard,
    sumMastercard: UInt,
    sumMaestro: UInt,
    sumVisa: UInt,
    sumMir: UInt,
    sumVkPay: UInt
): UInt {
    return when (typeOfCard) {
        TypeOfCard.MASTERCARD -> sumMastercard
        TypeOfCard.MAESTRO -> sumMaestro
        TypeOfCard.VISA -> sumVisa
        TypeOfCard.MIR -> sumMir
        TypeOfCard.VK_PAY -> sumVkPay
    }
}

fun calculateCommission(typeOfCard: TypeOfCard, sumPreviousTransfer: UInt, sumTransfer: UInt): UInt {
    return when (typeOfCard) {
        TypeOfCard.MASTERCARD -> calculateMastercardMaestro(sumPreviousTransfer, sumTransfer)
        TypeOfCard.MAESTRO -> calculateMastercardMaestro(sumPreviousTransfer, sumTransfer)
        TypeOfCard.VISA -> calculateVisaMir(sumTransfer)
        TypeOfCard.MIR -> calculateVisaMir(sumTransfer)
        TypeOfCard.VK_PAY -> 0U
    }
}

fun calculateMastercardMaestro(sumPreviousTransfer: UInt, sumTransfer: UInt): UInt {
    val maxTransfer = 75_000_00U
    val commissionPercent = 0.006
    val commissionConstant = 20_00U
    return if ((sumPreviousTransfer + sumTransfer) < maxTransfer) {
        0U
    } else {
        (sumTransfer.toDouble() * commissionPercent + commissionConstant.toDouble()).toUInt()
    }
}

fun calculateVisaMir(sumTransfer: UInt): UInt {
    val commissionPercent = 0.0075
    val commissionConstant = 35_00U

    return if ((sumTransfer.toDouble() * commissionPercent) < commissionConstant.toDouble()) {
        commissionConstant
    } else {
        (sumTransfer.toDouble() * commissionPercent).toUInt()
    }
}

fun isAvailableLimits(typeOfCard: TypeOfCard, sumPreviousTransfer: UInt, sumTransfer: UInt): Boolean {
    val limitOfCards = 600_000_00U
    val limitVkPayDay = 40_000_00U
    val limitVkPay = 15_000_00U
    return when (typeOfCard) {
        TypeOfCard.VK_PAY -> (sumPreviousTransfer + sumTransfer) <= limitVkPayDay && sumTransfer <= limitVkPay
        else -> (sumPreviousTransfer + sumTransfer) <= limitOfCards
    }
}

