package analytics.textanalytics;

import java.util.HashMap;
import java.util.function.Function;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AnalyticsController {

/*     @GetMapping("/greeting")
    public String myGreetings(@RequestParam(value = "name", defaultValue = "World!", required = false) String name){
        String template = "Hello, %s";
        return String.format(template, name);

    } */

    @PostMapping("/json")
    public HashMap<String, Integer> json(@RequestBody JSONSchema request_body){
        String[] wordArray = request_body.splitToWords();

        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (int i = 0; i < wordArray.length; i++) {
            Integer count = 0;
            for (int j = 0; j < wordArray.length; j++) {
                if (wordArray[i].equals(wordArray[j])){
                    count ++;
                };
                result.put(wordArray[i], count);
            }
        }

        result.put("word_count", wordArray.length);

        int capitalCount = request_body.capitalFirstCount();
        result.put("starts_with_uppercase", capitalCount);

        return result;

    }



}