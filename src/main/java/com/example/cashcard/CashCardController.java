package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cashcard")
public class CashCardController {

    private final CashCardRepository cashCardRepository;

    public CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    @GetMapping("/{id}")
    private ResponseEntity<CashCard> findById(@PathVariable Long id) {
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(id);
        return cashCardOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    private ResponseEntity<CashCard> addCashCard(@RequestBody CashCard cashCard){
        var saveCashCard = cashCardRepository.save(cashCard);
        return ResponseEntity.ok(saveCashCard);

    }
}
