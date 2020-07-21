package com.example.springCheckpoint;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PageController {

    @GetMapping("/camelize")
    public String camel(@RequestParam (value = "original", required = true) String original,
                        @RequestParam (value = "initialCap", required = false) String allCaps){
        String[] result = original.split("_");
        String finale = "";
        if (allCaps != null) {
            for (int i = 0; i < result.length; i++) {
                if (result[i].length() > 1) {
                    finale += result[i].substring(0, 1).toUpperCase() + result[i].substring(1);
                } else {
                    result[i] = result[i].toUpperCase();
                }
            }
        }else {
            finale += result[0];
            for (int i = 1; i < result.length; i++) {
                if (result[i].length() > 1) {
                    finale += result[i].substring(0, 1).toUpperCase() + result[i].substring(1);
                } else {
                    result[i] = result[i].toUpperCase();
                }
            }
        }
        return finale;
    }

    @GetMapping("/redact")
    public String redact(@RequestParam (value = "original") String original,
                         @RequestParam (value = "badWords") List<String> badWords){
        String[] workingList = original.split(" ");
        String finale;

        for (int i = 0; i < workingList.length; i++) {
            if (badWords.contains(workingList[i])){
                String temp = "*".repeat(workingList[i].length());
                workingList[i] = temp;
            }
            else {
                continue;
            }
        }

        finale = String.join(" ", workingList);
        return finale;
    }


    @PostMapping("/encode")
    public String encode(@RequestParam (value = "message") String message,
                         @RequestParam (value = "key") String key){
        String[] workingList = message.split(" ");
        List<String> alphabet = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));
        List<String> keyList = Arrays.asList(key.split(""));

        for (int i = 0; i < workingList.length; i++) {
            for (int j = 0; j < workingList[i].length(); j++) {
                String temp = "";
                String character = workingList[i].substring(j, j + 1);


            }
        }

        return String.valueOf(alphabet.indexOf("d"));
    }



}
