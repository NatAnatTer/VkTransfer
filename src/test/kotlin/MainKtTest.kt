import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun main() {
    }

    @Test
    fun sumPreviousTransferTest_Mastercard() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MASTERCARD
        val sumMastercardTest: UInt = 0U
        val sumMaestroTest: UInt = 0U
        val sumVisaTest: UInt = 0U
        val sumMirTest: UInt = 0U
        val sumVkPayTest: UInt = 0U

        val result = sumPreviousTransfer(
            typeOfCard = typeOfCardTest,
            sumMastercard = sumMastercardTest,
            sumMaestro = sumMaestroTest,
            sumVisa = sumVisaTest,
            sumMir = sumMirTest,
            sumVkPay = sumVkPayTest
        )
        assertEquals(sumMastercardTest, result)
    }

    @Test
    fun sumPreviousTransferTest_Maestro() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MAESTRO
        val sumMastercardTest: UInt = 0U
        val sumMaestroTest: UInt = 0U
        val sumVisaTest: UInt = 0U
        val sumMirTest: UInt = 0U
        val sumVkPayTest: UInt = 0U

        val result = sumPreviousTransfer(
            typeOfCard = typeOfCardTest,
            sumMastercard = sumMastercardTest,
            sumMaestro = sumMaestroTest,
            sumVisa = sumVisaTest,
            sumMir = sumMirTest,
            sumVkPay = sumVkPayTest
        )
        assertEquals(sumMaestroTest, result)
    }

    @Test
    fun sumPreviousTransferTest_Visa() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.VISA
        val sumMastercardTest: UInt = 0U
        val sumMaestroTest: UInt = 0U
        val sumVisaTest: UInt = 0U
        val sumMirTest: UInt = 0U
        val sumVkPayTest: UInt = 0U

        val result = sumPreviousTransfer(
            typeOfCard = typeOfCardTest,
            sumMastercard = sumMastercardTest,
            sumMaestro = sumMaestroTest,
            sumVisa = sumVisaTest,
            sumMir = sumMirTest,
            sumVkPay = sumVkPayTest
        )
        assertEquals(sumVisaTest, result)
    }

    @Test
    fun sumPreviousTransferTest_Mir() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MIR
        val sumMastercardTest: UInt = 0U
        val sumMaestroTest: UInt = 0U
        val sumVisaTest: UInt = 0U
        val sumMirTest: UInt = 0U
        val sumVkPayTest: UInt = 0U

        val result = sumPreviousTransfer(
            typeOfCard = typeOfCardTest,
            sumMastercard = sumMastercardTest,
            sumMaestro = sumMaestroTest,
            sumVisa = sumVisaTest,
            sumMir = sumMirTest,
            sumVkPay = sumVkPayTest
        )
        assertEquals(sumMirTest, result)
    }

    @Test
    fun sumPreviousTransferTest_VkPay() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.VK_PAY
        val sumMastercardTest: UInt = 0U
        val sumMaestroTest: UInt = 0U
        val sumVisaTest: UInt = 0U
        val sumMirTest: UInt = 0U
        val sumVkPayTest: UInt = 0U

        val result = sumPreviousTransfer(
            typeOfCard = typeOfCardTest,
            sumMastercard = sumMastercardTest,
            sumMaestro = sumMaestroTest,
            sumVisa = sumVisaTest,
            sumMir = sumMirTest,
            sumVkPay = sumVkPayTest
        )
        assertEquals(sumVkPayTest, result)
    }

    //    @Test
//    fun calculateCommission() {
//    }
//
    @Test
    fun calculateMastercardMaestroTest_UnderLimit() {
        val sumPreviousTransferTest: UInt = 40_000_00U
        val sumTransferTest: UInt = 12_000_00U
        val result = calculateMastercardMaestro(
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(0U, result)
    }
    @Test
    fun calculateMastercardMaestroTest_OverLimit() {
        val sumPreviousTransferTest: UInt = 40_000_00U
        val sumTransferTest: UInt = 36_000_00U
        val result = calculateMastercardMaestro(
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(236_00U, result)
    }

    @Test
    fun calculateVisaMirTest_ComissionConstant() {
        val sumTransferTest: UInt = 1_000_00U
        val result = calculateVisaMir(
            sumTransfer = sumTransferTest
        )
        assertEquals(35_00U, result)
    }

    @Test
    fun calculateVisaMirTest_ComissionCalculated() {
        val sumTransferTest: UInt = 100_000_00U
        val result = calculateVisaMir(
            sumTransfer = sumTransferTest
        )
        assertEquals(750_00U, result)
    }

    @Test
    fun calculateVisaMirFailedTest_ComissionCalculated() {
        val sumTransferTest: UInt = 100_000_00U
        val result = calculateVisaMir(
            sumTransfer = sumTransferTest
        )
        assertEquals(7500_00U, result)
    }


    @Test
    fun isAvailableLimitsTest_Mastercard_OverLimits() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MASTERCARD
        val sumPreviousTransferTest: UInt = 599_000_00U
        val sumTransferTest: UInt = 10_000_00U
        val result = isAvailableLimits(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(false, result)
    }

    @Test
    fun isAvailableLimitsFailedTest_MIR_UnderLimits() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MIR
        val sumPreviousTransferTest: UInt = 400_000_00U
        val sumTransferTest: UInt = 10_000_00U
        val result = isAvailableLimits(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(false, result)
    }

    @Test
    fun isAvailableLimitsTest_VkPay_OverLimitOfDay() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.VK_PAY
        val sumPreviousTransferTest: UInt = 39_000_00U
        val sumTransferTest: UInt = 10_000_00U
        val result = isAvailableLimits(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(false, result)
    }

    @Test
    fun isAvailableLimitsTest_VkPay_UnderLimitsTransaction() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.VK_PAY
        val sumPreviousTransferTest: UInt = 10_000_00U
        val sumTransferTest: UInt = 10_000_00U
        val result = isAvailableLimits(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(true, result)
    }
}