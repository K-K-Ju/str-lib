package io.str_counter.ua;


import java.util.List;
import java.util.Map;

/**
 * <h1>Method Description</h1>
 *
 * <p>Method, that accepts a {@code List<String>} and returns
 * {@code Map<String, Integer>}, were <em>String</em> is character and
 * <em></Integer> is num of occurrences in the strings
 * </p>
 */
public interface CharacterCounter {
    Map<String, Integer> countCharacters(List<String> string);
}
