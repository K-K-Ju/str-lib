package io.str_counter.ua;

import java.util.*;
import java.util.regex.Pattern;

public class CharacterCounterImpl implements CharacterCounter {
    private static Pattern numbers = Pattern.compile("[0-9]+");

    @Override
    public Map<String, Integer> countCharacters(List<String> lines) {
        if(lines == null) throw new NullPointerException("List can't be null");
        if(lines.isEmpty()) throw new IllegalArgumentException("List can't be empty");

        var charsFrequency = new HashMap<String, Integer>();

        lines.forEach( line ->
            Arrays.stream(line.split(""))
                    .filter(ch -> !numbers.matcher(ch).matches() && !ch.equals(" "))
                    .map(ch -> {
                        if(ch.equals("\n")) {
                            return "newLineChar";
                        }
                        return ch;
                    })
                    .forEach(ch -> charsFrequency.put(ch, Optional.ofNullable(charsFrequency.get(ch)).orElse(0) + 1))
        );

        return charsFrequency;
    }
}
