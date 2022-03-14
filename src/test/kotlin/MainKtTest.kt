import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {


    @Test
    fun defineTypeOfCardTest_Mastercard() {
        val typeOfCardUerChoiceTest: UInt = 1U

        val result = defineTypeOfCard(
            typeOfCardUerChoice = typeOfCardUerChoiceTest
        )
        assertEquals(TypeOfCard.MASTERCARD, result)
    }

    @Test
    fun defineTypeOfCardTest_Maestro() {
        val typeOfCardUerChoiceTest: UInt = 2U

        val result = defineTypeOfCard(
            typeOfCardUerChoice = typeOfCardUerChoiceTest
        )
        assertEquals(TypeOfCard.MAESTRO, result)
    }

    @Test
    fun defineTypeOfCardTest_Visa() {
        val typeOfCardUerChoiceTest: UInt = 3U

        val result = defineTypeOfCard(
            typeOfCardUerChoice = typeOfCardUerChoiceTest
        )
        assertEquals(TypeOfCard.VISA, result)
    }

    @Test
    fun defineTypeOfCardTest_Mir() {
        val typeOfCardUerChoiceTest: UInt = 4U

        val result = defineTypeOfCard(
            typeOfCardUerChoice = typeOfCardUerChoiceTest
        )
        assertEquals(TypeOfCard.MIR, result)
    }

    @Test
    fun defineTypeOfCardTest_Vk_Pay() {
        val typeOfCardUerChoiceTest: UInt = 5U

        val result = defineTypeOfCard(
            typeOfCardUerChoice = typeOfCardUerChoiceTest
        )
        assertEquals(TypeOfCard.VK_PAY, result)
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


    @Test
    fun calculateCommissionTest_VkPay() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.VK_PAY
        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 14_000_00U

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(0U, result)
    }

    @Test
    fun calculateCommissionTest_Mastercard_UnderLimit() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MASTERCARD
        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 14_000_00U

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(0U, result)
    }

    @Test
    fun calculateCommissionTest_Mastercard_OverLimit() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MASTERCARD
        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 100_000_00U

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(620_00U, result)
    }

    @Test
    fun calculateCommissionTest_Maestro_UnderLimit() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MAESTRO
        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 14_000_00U

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(0U, result)
    }

    @Test
    fun calculateCommissionTest_Maestro_OverLimit() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MAESTRO
        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 100_000_00U

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(620_00U, result)
    }

    @Test
    fun calculateCommissionTest_Visa_UnderMinSum() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.VISA
        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 1_000_00U

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(35_00U, result)
    }

    @Test
    fun calculateCommissionTest_Visa_OverMinSum() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.VISA
        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 100_000_00U

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(750_00U, result)
    }

    @Test
    fun calculateCommissionTest_Mir_UnderMinSum() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MIR
        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 1_000_00U

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(35_00U, result)
    }

    @Test
    fun calculateCommissionTest_Mir_OverMinSum() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MIR
        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 100_000_00U

        val result = calculateCommission(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(750_00U, result)
    }

    @Test
    fun calculateCommissionTest_VkPay_Default() {

        val sumPreviousTransferTest: UInt = 0U
        val sumTransferTest: UInt = 100_000_00U

        val result = calculateCommission(

            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(0U, result)
    }


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
    fun calculateVisaMir_ComissionCalculated() {
        val sumTransferTest: UInt = 100_000_00U
        val result = calculateVisaMir(
            sumTransfer = sumTransferTest
        )
        assertEquals(750_00U, result)
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
    fun isAvailableLimits_MIR_UnderLimits() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.MIR
        val sumPreviousTransferTest: UInt = 400_000_00U
        val sumTransferTest: UInt = 10_000_00U
        val result = isAvailableLimits(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(true, result)
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

    @Test
    fun isAvailableLimitsTest_VkPay_OverLimitTransaction() {
        val typeOfCardTest: TypeOfCard = TypeOfCard.VK_PAY
        val sumPreviousTransferTest: UInt = 10_000_00U
        val sumTransferTest: UInt = 19_000_00U
        val result = isAvailableLimits(
            typeOfCard = typeOfCardTest,
            sumPreviousTransfer = sumPreviousTransferTest,
            sumTransfer = sumTransferTest
        )
        assertEquals(false, result)
    }
}