package org.example.app;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.WordUtils;
import org.example.list.LinkedList;
import org.springframework.stereotype.Service;

import static org.example.app.MessageUtils.getMessage;
import static org.example.utilities.StringUtils.join;
import static org.example.utilities.StringUtils.split;

@Service
@Slf4j
public class ExampleService {

    public String hello(String toCapitalize) {
        var tokens = split(toCapitalize);
        var result = join(tokens);
        var capitalized = WordUtils.capitalize(result);
        log.info("service response: {}", capitalized);
        return "Hello mr. " + capitalized;
    }
}
