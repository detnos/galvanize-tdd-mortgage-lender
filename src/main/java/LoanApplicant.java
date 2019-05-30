import java.math.BigDecimal;

public class LoanApplicant {
    private BigDecimal downPayment;
    private BigDecimal requestedAmount;
    private BigDecimal monthlyGrossIncome;
    private BigDecimal monthlyDebtLoad;
    private int creditScore;

    public LoanApplicant(BigDecimal downPayment, BigDecimal monthlyGrossIncome, BigDecimal monthlyDebtLoad, int creditScore) {
            this.downPayment = downPayment;
            this.monthlyGrossIncome = monthlyGrossIncome;
            this.monthlyDebtLoad = monthlyDebtLoad;
            this.creditScore = creditScore;
        }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public BigDecimal getMonthlyGrossIncome() {
        return monthlyGrossIncome;
    }

    public void setMonthlyGrossIncome(BigDecimal monthlyGrossIncome) {
        this.monthlyGrossIncome = monthlyGrossIncome;
    }

    public BigDecimal getMonthlyDebtLoad() {
        return monthlyDebtLoad;
    }

    public void setMonthlyDebtLoad(BigDecimal monthlyDebtLoad) {
        this.monthlyDebtLoad = monthlyDebtLoad;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

}
