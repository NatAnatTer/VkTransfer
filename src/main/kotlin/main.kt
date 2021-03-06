const val MAX_TRANSFER_MASTERCARD_MAESTRO = 75_000_00U
const val COMMISSION_PERCENT_MASTERCARD_MAESTRO = 0.006
const val COMMISSION_CONSTANT_MASTERCARD_MAESTRO = 20_00U
const val COMMISSION_PERCENT_VISA_MIR = 0.0075
const val COMMISSION_CONSTANT_VISA_MIR = 35_00U
const val LIMIT_OF_CARDS = 600_000_00U
const val LIMIT_VK_PAY_DAY = 40_000_00U
const val LIMIT_VK_PAY = 15_000_00U

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

        val typeOfCardUerChoice: UInt
        try {
            typeOfCardUerChoice = readLine()?.toUInt() ?: return
        } catch (e: Exception) {
            println("Введена не допустимая команда")
            continue
        }
        if (typeOfCardUerChoice > 6U) {
            println("Введена не допустимая команда, повторите попытку снова")
            continue
        }

        if (typeOfCardUerChoice == 6U) return

        typeOfCard = defineTypeOfCard(typeOfCardUerChoice)

        print("Введите сумму перевода в копейках: ")
        val sumTransfer: UInt
        try {
            sumTransfer = readLine()?.toUInt() ?: return
        } catch (e: Exception) {
            println("Введена не допустимая сумма")
            continue
        }

        val sumPrevious = sumPreviousTransfer(
            typeOfCard,
            sumMastercard,
            sumMaestro,
            sumVisa,
            sumMir,
            sumVkPay
        )
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
            sumPrevious,
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


fun defineTypeOfCard(typeOfCardUerChoice: UInt) = when (typeOfCardUerChoice) {
    1U -> TypeOfCard.MASTERCARD
    2U -> TypeOfCard.MAESTRO
    3U -> TypeOfCard.VISA
    4U -> TypeOfCard.MIR
    else -> TypeOfCard.VK_PAY

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

fun calculateCommission(
    typeOfCard: TypeOfCard = TypeOfCard.VK_PAY,
    sumPreviousTransfer: UInt,
    sumTransfer: UInt
): UInt {
    return when (typeOfCard) {
        TypeOfCard.MASTERCARD, TypeOfCard.MAESTRO -> calculateMastercardMaestro(sumPreviousTransfer, sumTransfer)
        TypeOfCard.VISA, TypeOfCard.MIR -> calculateVisaMir(sumTransfer)
        TypeOfCard.VK_PAY -> 0U
    }
}

fun calculateMastercardMaestro(sumPreviousTransfer: UInt, sumTransfer: UInt) =
    if ((sumPreviousTransfer + sumTransfer) < MAX_TRANSFER_MASTERCARD_MAESTRO) {
        0U
    } else {
        (sumTransfer.toDouble() * COMMISSION_PERCENT_MASTERCARD_MAESTRO + COMMISSION_CONSTANT_MASTERCARD_MAESTRO.toDouble()).toUInt()
    }


fun calculateVisaMir(sumTransfer: UInt) =
    if ((sumTransfer.toDouble() * COMMISSION_PERCENT_VISA_MIR) < COMMISSION_CONSTANT_VISA_MIR.toDouble()) {
        COMMISSION_CONSTANT_VISA_MIR
    } else {
        (sumTransfer.toDouble() * COMMISSION_PERCENT_VISA_MIR).toUInt()
    }


fun isAvailableLimits(typeOfCard: TypeOfCard, sumPreviousTransfer: UInt, sumTransfer: UInt) =
    when (typeOfCard) {
        TypeOfCard.VK_PAY -> (sumPreviousTransfer + sumTransfer) <= LIMIT_VK_PAY_DAY && sumTransfer <= LIMIT_VK_PAY
        else -> (sumPreviousTransfer + sumTransfer) <= LIMIT_OF_CARDS
    }


