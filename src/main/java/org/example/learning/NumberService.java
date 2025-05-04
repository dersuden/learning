package org.example.learning;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberService {

    private final List<String> numbers = new ArrayList<>();

    public void saveNumber(String number) {
        numbers.add(number);
    }

    public String getNumbersAsString() {
        return String.join(", ", numbers);
    }
}
