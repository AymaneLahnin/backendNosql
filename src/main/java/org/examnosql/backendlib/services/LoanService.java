package org.examnosql.backendlib.services;
import org.examnosql.backendlib.models.Book;
import org.examnosql.backendlib.models.Loan;
import org.examnosql.backendlib.repositories.BookRepository;
import org.examnosql.backendlib.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookMongoRepository;

    public Loan addLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan updateLoanStatus(String loanId, String status) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
        loan.setStatus(status);
        Loan updatedLoan = loanRepository.save(loan);

        if ("retourné".equalsIgnoreCase(status)) {
            Book book = bookMongoRepository.findById(loan.getLivreId()).orElseThrow(() -> new RuntimeException("Book not found"));
            book.setNmbCopie(book.getNmbCopie() + 1);
            bookMongoRepository.save(book);
        }
        else {
            Book book = bookMongoRepository.findById(loan.getLivreId()).orElseThrow(() -> new RuntimeException("Book not found"));
            book.setNmbCopie(book.getNmbCopie() - 1);
            bookMongoRepository.save(book);
        }

        return updatedLoan;
    }

    public void deleteLoan(String loanId) {
        loanRepository.deleteById(loanId);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
