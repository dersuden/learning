package org.example.learning;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberService {

    private final List<String> numbers = new ArrayList<>();
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final int BATCH_SIZE = 100;
    private static final String TOPIC_NAME = "FromIDEWithLove";

    public NumberService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public synchronized void saveNumber(String number) {
        numbers.add(number);
        if (numbers.size() >= BATCH_SIZE) {
            String numbersString = getNumbersAsString();
            kafkaTemplate.send(TOPIC_NAME, numbersString);
            numbers.clear();
        }
    }

    public String getNumbersAsString() {
        return String.join(", ", numbers);
    }
}
