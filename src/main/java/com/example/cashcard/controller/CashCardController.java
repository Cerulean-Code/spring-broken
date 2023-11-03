package com.example.cashcard.controller;

import com.example.cashcard.CashCard;
import com.example.cashcard.repository.CashCardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    private CashCardRepository cashCardRepository;

    public CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> findId(@PathVariable Long requestedId) {

        Optional<CashCard> cashcardOptional = cashCardRepository.findById(requestedId);

        if (cashcardOptional.isPresent()) {
            return ResponseEntity.ok(cashcardOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
