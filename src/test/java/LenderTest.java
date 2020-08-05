import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


final class LenderTest {

    @Test
    void getAvailableFundsReturnsZeroByDefault() {
        //Setup
        final Lender lender = new Lender();
        final long expected = 0L;

        //Exercise
        final long actual = lender.getAvailableFunds();

        //Assert
        assertThat(actual).isEqualTo(expected);

        //Teardown
    }

    @Test
    void addFundsThrowsAnExceptionForZero(){
        //Setup
        final Lender lender = new Lender();
        final String expected = "Amount added must be greater than zero.";

        //Exercise
        final Exception actual = assertThrows(IllegalArgumentException.class,
                () -> lender.addFunds(0L));

        //Assert
        assertThat(actual.getMessage()).isEqualTo(expected);
    }

    @Test
    void addFundsIncreasesAvailableFundsByOne(){
        //Setup
        final Lender lender = new Lender();
        final long expected = 1L;

        //Exercise
        lender.addFunds(expected);

        final long actual = lender.getAvailableFunds();

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addFundsThrowsAnExceptionForNegativeValue(){
        //Setup
        final Lender lender = new Lender();
        final String expected = "Amount added must be greater than zero.";

        //Exercise
        final Exception actual = assertThrows(IllegalArgumentException.class,
                () -> lender.addFunds(Long.MIN_VALUE));

        //Assert
        assertThat(actual.getMessage()).isEqualTo(expected);
    }

    @Test
    void addFundsIncreasesAvailableFundsByTwo(){
        //Setup
        final Lender lender = new Lender();
        final long expected = 2L;

        //Exercise
        lender.addFunds(expected);

        final long actual = lender.getAvailableFunds();

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addFundsIncreasesAvailableFundsByThreeThenFour(){
        //Setup
        final Lender lender = new Lender();
        final long expected = 7L;

        //Exercise
        lender.addFunds(3L);
        lender.addFunds(4L);

        final long actual = lender.getAvailableFunds();

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addFundsThrowExceptionIfOverflowWillHappen(){
        //Setup
        final Lender lender = new Lender();
        lender.addFunds(Long.MAX_VALUE);
        final String expected = "long overflow";

        //Exercise
        final Exception actual = assertThrows(ArithmeticException.class,
                () -> lender.addFunds(1L));

        //Assert
        assertThat(actual.getMessage()).isEqualTo(expected);
    }
}
