package com.example.cashApplication.service;

import com.example.cashApplication.model.Loan;
import com.example.cashApplication.model.LoanDTO;
import com.example.cashApplication.repository.LoanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    ModelMapper modelMapper;

    public Integer createLoan(LoanDTO loanDTO) {
        Loan loan = modelMapper.map(loanDTO, Loan.class);

        Loan savedLoan = loanRepository.save(loan);

        return savedLoan.getLoanId();
    }

    public List<LoanDTO> getLoans(Integer userId, Integer page, Integer size) {
        List<Loan> loans;

        if (userId != null)
            loans = loanRepository.findByUserId(userId, PageRequest.of(page, size));
        else
            loans = loanRepository.findAll(PageRequest.of(page, size)).getContent();

        List<LoanDTO> loanDTOS = loans.stream().map(loan -> modelMapper.map(loan, LoanDTO.class)).collect(Collectors.toList());

        return loanDTOS;
    }
}
