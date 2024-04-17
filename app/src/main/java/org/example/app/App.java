package org.example.app;

import org.example.list.LinkedList;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.example.utilities.StringUtils.join;
import static org.example.utilities.StringUtils.split;
import static org.example.app.MessageUtils.getMessage;

import org.apache.commons.text.WordUtils;


@SpringBootApplication
public class App implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    @Override
    public void run(ApplicationArguments args) {
        LinkedList tokens;
        tokens = split(getMessage());
        String result = join(tokens);
        System.out.println(WordUtils.capitalize(result));
    }
}
