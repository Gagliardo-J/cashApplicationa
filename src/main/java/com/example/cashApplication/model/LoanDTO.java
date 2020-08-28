package com.example.cashApplication.model;

public class LoanDTO {
    private int loanId;
    private float total;
    private int userId;

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String  toString() {
        return "LoanDTO{" +
                "loanId=" + loanId +
                ", total=" + total +
                ", userId=" + userId +
                '}';
    }
}
