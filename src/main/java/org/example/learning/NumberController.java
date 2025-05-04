package org.example.learning;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/numbers")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping
    public void saveNumber(@RequestBody NumberRequest request) {
        numberService.saveNumber(request.getNumber());
    }

    @GetMapping
    public String getNumbers() {
        return numberService.getNumbersAsString();
    }
}
