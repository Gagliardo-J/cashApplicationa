package com.example.cashApplication.repository;

import com.example.cashApplication.model.Loan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LoanRepository extends PagingAndSortingRepository<Loan, Integer> {

    public List<Loan> findByUserId(Integer userId, Pageable pageable);

    public List<Loan> findByUserId(Integer userId);

    @Transactional
    public List<Loan> deleteByUserId(Integer userId);
}
