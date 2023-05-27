package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.stream()
                .filter(word -> word.charAt(0) == Character.toUpperCase(word.charAt(0))
                && !Character.isDigit(word.charAt(0)))
                .count() == x.size();
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> x.addAll(x.stream().filter(y -> y % 2 == 0).collect(Collectors.toList()));
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(x -> x.matches("^[A-Z].+")
                && x.endsWith(".") && x.split(" ").length > 3).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> size = new HashMap<>();
            x.forEach(i -> size.put(i, i.length()));
            return size;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(x);
            result.addAll(y);
            return result;
        };
    }
}
