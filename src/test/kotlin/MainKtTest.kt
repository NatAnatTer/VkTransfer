//import org.junit.jupiter.api.Test
import junit.framework.Assert.assertEquals
import org.junit.Test

class MainKtTest {

//    @Test
//    fun sumPreviousTransferMasterCard() {
//        val typeCard = "Mastercard"
//        val result = sumPreviousTransfer(
//            typeOfCard = typeCard
//        )
//        assertEquals(sumMastercard, result)
//    }

//    @Test
//    fun sumPreviousTransferMaestro() {
//        val typeCard = "Maestro"
//        val result = sumPreviousTransfer(
//            typeOfCard = typeCard
//        )
//        assertEquals(sumMaestro, result)
//    }

//    @Test
//    fun sumPreviousTransferVisa() {
//        val typeCard = "Visa"
//        val result = sumPreviousTransfer(
//            typeOfCard = typeCard
//        )
//        assertEquals(sumVisa, result)
//    }

//    @Test
//    fun sumPreviousTransferMir() {
//        val typeCard = "Mir"
//        val result = sumPreviousTransfer(
//            typeOfCard = typeCard
//        )
//        assertEquals(sumMir, result)
//    }

//    @Test
//    fun sumPreviousTransferVkPay() {
//        val typeCard = "vkPay"
//        val result = sumPreviousTransfer(
//            typeOfCard = typeCard
//        )
//        assertEquals(sumVkPay, result)
//    }

    @Test
    fun main() {
    }

//    @Test
//    fun getSumMastercard() {
//        println("hi")
//        assert(true)
//    }

//    @Test
//    fun getScan() {
//    }
//
//    @Test
//    fun setScan() {
//    }

    @Test
    fun testGetSumMastercard() {
        val typeCard = "Mastercard"
        val result = sumPreviousTransfer(
            typeOfCard = typeCard
        )
        assertEquals(sumMastercard, result)
    }

    @Test
    fun setSumMastercard() {
        val typeCard = "Mastercard"
        val sumTransferTest : Long = 20_000_00

        val result = sumPreviousAfterTransfer(
            typeOfCard = typeCard,
            sumTransfer = sumTransferTest

        )

        assertEquals(testGetSumMastercard(), result)
    }

    @Test
    fun getSumMaestro() {
        val typeCard = "Maestro"
        val result = sumPreviousTransfer(
            typeOfCard = typeCard
        )
        assertEquals(sumMaestro, result)
    }

    @Test
    fun setSumMaestro() {
        val typeCard = "Maestro"
        val sumTransferTest : Long = 20_000_00

        val result = sumPreviousAfterTransfer(
            typeOfCard = typeCard,
            sumTransfer = sumTransferTest
        )

        assertEquals(getSumMaestro(), result)
    }

    @Test
    fun getSumVisa() {
        val typeCard = "Visa"
        val result = sumPreviousTransfer(
            typeOfCard = typeCard
        )
        assertEquals(sumVisa, result)
    }

    @Test
    fun setSumVisa() {
        val typeCard = "Visa"
        val sumTransferTest : Long = 20_000_00

        val result = sumPreviousAfterTransfer(
            typeOfCard = typeCard,
            sumTransfer = sumTransferTest
        )

        assertEquals(getSumVisa(), result)
    }

    @Test
    fun getSumMir() {
        val typeCard = "Mir"
        val result = sumPreviousTransfer(
            typeOfCard = typeCard
        )
        assertEquals(sumMir, result)
    }

    @Test
    fun setSumMir() {
        val typeCard = "Mir"
        val sumTransferTest : Long = 20_000_00

        val result = sumPreviousAfterTransfer(
            typeOfCard = typeCard,
            sumTransfer = sumTransferTest
        )

        assertEquals(getSumMir(), result)
    }

    @Test
    fun getSumVkPay() {
        val typeCard = "vkPay"
        val result = sumPreviousTransfer(
            typeOfCard = typeCard
        )
        assertEquals(sumVkPay, result)
    }

    @Test
    fun setSumVkPay() {
        val typeCard = "vkPay"
        val sumTransferTest : Long = 15_000_00

        val result = sumPreviousAfterTransfer(
            typeOfCard = typeCard,
            sumTransfer = sumTransferTest
        )

        assertEquals(getSumVkPay(), result)
    }

    @Test
    fun testMain() {
    }

    @Test
    fun testSumPreviousTransfer() {

    }

    @Test
    fun sumPreviousAfterTransfer() {
    }

    @Test
    fun calculateCommission() {
    }

    @Test
    fun calculateMastercardMaestroUnderLimit() {
        val sumPreviousTransferMoney: Long = 0
        val sumTransferTest : Long = 20_000_00

        var sumPreviousTransfer =  sumPreviousTransfer(typeOfCard = "Mastercard")

        val result = calculateMastercardMaestro(
            sumPreviousTransfer = sumPreviousTransferMoney,
            sumTransfer = sumTransferTest
        )
        assertEquals(0.0, result)
    }
    @Test
    fun calculateMastercardMaestroUpOfLimit() {
        val sumPreviousTransferMoney: Long = 0
        val sumTransferTest : Long = 80_000_00
        val commissionPercentTest : Double = 0.006
        val commissionConstantTest : Int = 20_00

        val result = calculateMastercardMaestro(
            sumPreviousTransfer = sumPreviousTransferMoney,
            sumTransfer = sumTransferTest,
        )
        assertEquals(sumTransferTest * commissionPercentTest + commissionConstantTest
            , result)
    }


    @Test
    fun calculateVisaMir() {
        val sumTransferTest : Long = 80_000_00
        val commissionPercent = 0.0075
        val commissionConstant = 35_00

        val result = calculateVisaMir( sumTransfer = sumTransferTest)
        assertEquals(sumTransferTest * commissionPercent + commissionConstant, result)
    }

    @Test
    fun isAvailableLimits() {


    }
}