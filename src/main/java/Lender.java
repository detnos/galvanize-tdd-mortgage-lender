final class Lender {

    private long availableFunds = 0;

    public long getAvailableFunds() {
        return this.availableFunds;
    }

    void addFunds(final long funds) {
        if(funds <= 0) {
            throw new IllegalArgumentException("Amount added must be greater than zero.");
        }
        this.availableFunds = Math.addExact(this.availableFunds, funds);
    }

    public ApplicationStatus loan(LoanApplicant applicant) {
        if(this.availableFunds < applicant.getRequestedAmount()) {
            return ApplicationStatus.INSUFFICIENT_FUNDS;
        }
        this.availableFunds = Math.subtractExact(applicant.getRequestedAmount(), this.availableFunds);
        return ApplicationStatus.LOAN_APPROVED;
    }
}
