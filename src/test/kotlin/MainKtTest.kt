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

    @Test
    fun sumPreviousTransferMaestro() {
        val typeCard = "Maestro"
        val result = sumPreviousTransfer(
            typeOfCard = typeCard
        )
        assertEquals(sumMaestro, result)
    }

    @Test
    fun sumPreviousTransferVisa() {
        val typeCard = "Visa"
        val result = sumPreviousTransfer(
            typeOfCard = typeCard
        )
        assertEquals(sumVisa, result)
    }

    @Test
    fun sumPreviousTransferMir() {
        val typeCard = "Mir"
        val result = sumPreviousTransfer(
            typeOfCard = typeCard
        )
        assertEquals(sumMir, result)
    }

    @Test
    fun sumPreviousTransferVkPay() {
        val typeCard = "vkPay"
        val result = sumPreviousTransfer(
            typeOfCard = typeCard
        )
        assertEquals(sumVkPay, result)
    }

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
        val sumTransferTest = 20_000_00

        val result = sumPreviousAfterTransfer(
            //typeOfCard = typeCard,

        )
    }

    @Test
    fun getSumMaestro() {
    }

    @Test
    fun setSumMaestro() {
    }

    @Test
    fun getSumVisa() {
    }

    @Test
    fun setSumVisa() {
    }

    @Test
    fun getSumMir() {
    }

    @Test
    fun setSumMir() {
    }

    @Test
    fun getSumVkPay() {
    }

    @Test
    fun setSumVkPay() {
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
    fun calculateMastercardMaestro() {
        val sumPreviousTransferMoney: Long = 0
        val sumTransferTest = 20_000_00
        var sumPreviousTransfer =  sumPreviousTransfer(typeOfCard = "Mastercard")

        val result = calculateMastercardMaestro(
           // sumPreviousTransfer = sumPreviousTransferMoney,
           // sumTransfer = sumTransferTest
        )
        assertEquals(0.0, result)


    }

    @Test
    fun calculateVisaMir() {
    }

    @Test
    fun isAvailableLimits() {
    }
}