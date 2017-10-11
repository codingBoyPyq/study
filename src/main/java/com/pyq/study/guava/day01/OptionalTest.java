package com.pyq.study.guava.day01;


import com.google.common.base.Optional;

/**
 * Created by pangyueqiang on 16/7/11.
 */
public class OptionalTest {
    public static void main(String[] args){
        Optional<Integer> possible = Optional.of(5);
        Optional<Integer> possible1 = Optional.absent();
        Optional<Integer> possible2 = Optional.fromNullable(null);
        //System.out.println(possible.get());
        //System.out.println(possible1.get());
        //System.out.println(possible2.get());

        System.out.println(possible2.isPresent());
        System.out.println(possible2.getClass());
        System.out.println(possible2.or(4));
        System.out.println(possible2.orNull());




    }
}
