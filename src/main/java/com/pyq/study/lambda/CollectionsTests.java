package com.pyq.study.lambda;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsTests {

    public static List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
    public static List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

    public static List<String> languages2 = null;

    public static void main(String[] args) {
        //test1();
        //test3();
        //transform();
        //test07();
        //System.out.println(doublePrice2String(8.1));
        LocalDateTime nowTime = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println(nowTime.getHour());

        System.out.println(String.format("十点%s:00",10));
    }

    public static void filter(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public static void transform(){
        List<String> transformToString  = Lists.transform(testList,(e) -> "|"+e.toString()+"|");
        System.out.println(transformToString.toString());
    }


    public static void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
        Stream<String>  stringStream = Stream.of("taobao");

        Stream.generate(new Supplier<Double>() {
            public Double get(){
                return Math.random();
            }
        }).limit(10).forEach(System.out::println);

        Stream.generate(() -> Math.random())
                .limit(10)
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(3, item -> item + 1).limit(10).forEach(System.out::println);
    }



    public static void test2() {
        Predicate<String> startWithJ = (str) -> str.startsWith("J");
        System.out.println("Languages which starts with J :");
        filter(languages, startWithJ);

        Predicate<String> endWithA = (str) -> str.endsWith("A");
        System.out.println("Languages which ends with a ");
        filter(languages, endWithA);

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        Predicate<String> lengthGt = (str) -> str.length() > 4;
        System.out.println("Print language whose length greater than 4:");
        filter(languages, lengthGt);
    }

    /**
     * 无序并行打印
     */
    public static void test1() {
        System.out.println(" print type one :");
        testList.parallelStream().forEach(System.out::print);
        System.out.println("\n print type two :");
        testList.parallelStream().forEach((e) -> System.out.print(e));
        System.out.println(" \n allMatch (e) -> e>5 :" + testList.parallelStream().allMatch((e) -> e > 5));


    }

    /**
     * 汇聚，和聚合
     * reduce collect
     */

    public static void test4(){
        testList.parallelStream().filter((e) -> e>5).collect(LinkedList::new, List::add, List::addAll);
        testList.parallelStream().filter((e) -> e>5).collect(Collectors.toList());
    }


    public static List<String> test5(){
        List<String> list = languages.stream().map(e -> {
            String str = new String("priffex");
            str += e;
            return str;
        }).collect(Collectors.toList());
        return list;
    }



    public static List<String> test6(){
        List<String> list = languages2.stream().limit(10).collect(Collectors.toList());
        return list;
    }

    public static void test07(){
        Model model1 = new Model(1,1);
        Model model2 = new Model(2,2);
        Model model3 = new Model(3,2);
        Model model4 = new Model(4,3);
        Model model5 = new Model(5,4);
        Model model6 = new Model(6,5);
        Model model7 = new Model(7,5);
        Model model8 = new Model(8,6);
        Model model9 = new Model(9,7);
        List<Model> list = Lists.newArrayList(model1,model2,model3,model4,model5,model6,model7,model8,model9);

        //List<Integer> list2 = list.stream().map(e -> e.getDealId()).distinct().collect(Collectors.toList());

        List<Model> list3 = list.stream().distinct().collect(Collectors.toList());
    }



    public static String doublePrice2String(double price) {
        BigDecimal b0 = BigDecimal.valueOf(0.1);
        BigDecimal b1 = BigDecimal.valueOf(price);
        BigDecimal b2 = BigDecimal.valueOf(Math.round(price));
        return b1.compareTo(b0) < 0 ? "0.1" :
                (b2.subtract(b1).compareTo(BigDecimal.valueOf(0)) == 0
                        ? String.valueOf(((long) price)) : String.valueOf(price));
    }

}
