package com.example.cashApplication.model;



import javax.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    private float total;

    //@ManyToOne
    //@JoinColumn(name = "userId", nullable = false)
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

    public void setUserId(int u) {
        this.userId = u;
    }
}
