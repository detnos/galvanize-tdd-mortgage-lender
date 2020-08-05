import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoanApplicantTest {

    @Test
    void defaultVariableAssignmentTest() {
        //Setup
        final int expectedCreditScore = 750;
        final int expectedDownPayment = 1000;
        final int expectedMonthlyDebtLoad = 3500;
        final int expectedMonthlyGrossIncome = 5000;
        final long expectedRequestedAmount = 10000L;
        final LoanApplicant applicant = new LoanApplicant(expectedDownPayment, expectedRequestedAmount, expectedMonthlyGrossIncome, expectedMonthlyDebtLoad, expectedCreditScore);

        //Exercise
        final int actualCreditScore = applicant.getCreditScore();
        final int actualDownPayment = applicant.getDownPayment();
        final int actualMonthlyDebtLoad = applicant.getMonthlyDebtLoad();
        final int actualMonthlyGrossIncome = applicant.getMonthlyGrossIncome();
        final long actualRequestedAmount = applicant.getRequestedAmount();

        //Assert
        assertThat(actualCreditScore).isEqualTo(expectedCreditScore);
        assertThat(actualDownPayment).isEqualTo(expectedDownPayment);
        assertThat(actualMonthlyDebtLoad).isEqualTo(expectedMonthlyDebtLoad);
        assertThat(actualMonthlyGrossIncome).isEqualTo(expectedMonthlyGrossIncome);
        assertThat(actualRequestedAmount).isEqualTo(expectedRequestedAmount);


        //Teardown
    }

}
