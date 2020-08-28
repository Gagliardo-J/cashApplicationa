package com.example.cashApplication.controller;

import com.example.cashApplication.model.LoanDTO;
import com.example.cashApplication.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    LoanService loanService;

    Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    @PostMapping("/loans/create")
    public String createLoan(@RequestBody LoanDTO loanDTO) {
        LOGGER.info("Crating a loan with ID " + loanDTO.getLoanId());

        Integer loan = loanService.createLoan(loanDTO);

        LOGGER.info("Loan created with ID " + loan);
        return "Loan created with ID " + loan;
    }

    @GetMapping("/loans")
    public List<LoanDTO> getLoans(@RequestParam(name = "page", required = true) Integer page, @RequestParam(name = "size", required = true) Integer size, @RequestParam(name = "userId", required = false) Integer userId) {

        LOGGER.info("Getting loans with page " + page + " and size " + size);
        List<LoanDTO> loans = loanService.getLoans(userId, page, size);

        return loans;
    }


}
