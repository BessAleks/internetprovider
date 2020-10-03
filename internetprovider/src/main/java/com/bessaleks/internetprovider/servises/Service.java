package com.bessaleks.internetprovider.servises;

import java.util.ArrayList;

public interface Service {
    public static <T> ArrayList<T> iterableToArray(Iterable<T> iterable) {
        ArrayList<T> t = new ArrayList<>();
        iterable.forEach(t::add);
        return t;
    }
}
