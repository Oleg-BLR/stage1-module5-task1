package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public static void main(String[] args) {
        InterfaceCreator interfaceCreator = new InterfaceCreator();
        List<String> listWithStrings = new ArrayList<>(List.of("47", "Word", "Case", "Human", "Price"));
        System.out.println(listWithStrings);
        interfaceCreator.isValuesStartWithUpperCase();
//        System.out.println(interfaceCreator.isValuesStartWithUpperCase());

        List<Integer> listEvenIntegers =new ArrayList<>(Arrays.asList(48, 56, 100, 200, 222));
        interfaceCreator.addEvenValuesAtTheEnd().accept(listEvenIntegers);

    }

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        System.out.println("Result of isValuesStartWithUpperCase Predicate Interface");
        return strings -> strings.stream()
                .allMatch(ss -> ss.length() > 0 && Character.isUpperCase(ss.charAt(0)));
//        throw new UnsupportedOperationException("You should implement this method.");
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        System.out.println("Result of addEvenValuesAtTheEnd");
        return listInt -> {
            listInt.addAll(listInt.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));
        };

//        List<Integer> evenElements = new ArrayList<>();
//        return list -> {
//            for (Integer i : list)
//                if (i % 2 == 0)
//                    evenElements.add(i);
//            list.addAll(evenElements);
//        };

//        return x->x.stream()
//                .filter(xx-> xx%2==0)
//                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("You should implement this method.");
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(s -> Character.isUpperCase(s.toCharArray()[0])).filter(s -> s.endsWith("."))
                .filter(s -> s.split(" ").length >3)
                .collect(Collectors.toList());
                //        return () -> values.stream().filter(s -> s.length() > 0 && Character.isUpperCase(s.charAt(0)) && (s -> s.endsWith("."))


//        throw new UnsupportedOperationException("You should implement this method.");
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream().collect(Collectors.toMap(m->m, String::length));
//        throw new UnsupportedOperationException("You should implement this method.");
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x1, x2)-> Stream.concat(x1.stream(), x2.stream()).collect(Collectors.toList());
//        throw new UnsupportedOperationException("You should implement this method.");
    }
}
