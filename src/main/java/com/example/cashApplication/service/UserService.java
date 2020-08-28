package com.example.cashApplication.service;

import com.example.cashApplication.model.Loan;
import com.example.cashApplication.model.LoanDTO;
import com.example.cashApplication.model.User;
import com.example.cashApplication.model.UserDTO;
import com.example.cashApplication.repository.LoanRepository;
import com.example.cashApplication.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    ModelMapper modelMapper;

    public Integer createUser(UserDTO userDTO) {

        User user = modelMapper.map(userDTO, User.class);

        User savedUSer = userRepository.save(user);

        return savedUSer.getUserId();
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();

        List<UserDTO> userDTOS = users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());

        return userDTOS;
    }

    public UserDTO getUser(Integer id) {
        Optional<User> userById = userRepository.findById(id);

        User user = userById.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + id + " does not exist"));

        List<Loan> loans = loanRepository.findByUserId(id);

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        List<LoanDTO> loanDTOS = loans.stream().map(loan -> modelMapper.map(loan, LoanDTO.class)).collect(Collectors.toList());

        userDTO.setLoans(loanDTOS);

        return userDTO;
    }

    public String deleteUser(Integer id) {
        List<Loan> loans = loanRepository.deleteByUserId(id);

        userRepository.deleteById(id);

        return "User " + id + " was deleted with " + loans.size() + " loans";
    }

}
