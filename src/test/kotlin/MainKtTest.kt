import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun main() {
    }


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
        val sumTransferTest: Long = 20_000_00

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
        val sumTransferTest: Long = 20_000_00

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
        val sumTransferTest: Long = 20_000_00

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
        val sumTransferTest: Long = 20_000_00

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
        val sumTransferTest: Long = 15_000_00

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
        val typeOfCardTest = "Mastercard"
        val sumPreviousTransferTest: Long = 0
        val sumTransferTest: Long = 20_000_00

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )

        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun calculateMastercardMaestroUnderLimit() {
        val sumPreviousTransferMoney: Long = 0
        val sumTransferTest: Long = 20_000_00 // correct 20_000_00

        var sumPreviousTransfer = sumPreviousTransfer(typeOfCard = "Mastercard")

        val result = calculateMastercardMaestro(
            sumPreviousTransfer = sumPreviousTransferMoney,
            sumTransfer = sumTransferTest
        )
        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun calculateMastercardMaestroUpOfLimit() {
        val sumPreviousTransferMoney: Long = 0
        val sumTransferTest: Long = 80_000_00
        val commissionPercentTest = 0.006
        val commissionConstantTest = 20_00

        val result = calculateMastercardMaestro(
            sumPreviousTransfer = sumPreviousTransferMoney,
            sumTransfer = sumTransferTest,
        )
        assertEquals(
            sumTransferTest * commissionPercentTest + commissionConstantTest, result, 0.0
        )
    }


    @Test
    fun calculateVisaMir() {
        val sumTransferTest: Long = 80_000_00
        val commissionPercent = 0.0075
        val commissionConstant = 35_00

        val result = calculateVisaMir(sumTransfer = sumTransferTest)
        assertEquals(sumTransferTest * commissionPercent + commissionConstant, result, 0.0)
    }

    @Test
    fun isAvailableLimits() {


    }
}