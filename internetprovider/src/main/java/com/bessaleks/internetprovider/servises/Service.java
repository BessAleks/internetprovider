package com.bessaleks.internetprovider.servises;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public static <T> List<T> iterableToArray(Iterable<T> iterable) {
        ArrayList<T> t = new ArrayList<>();
        iterable.forEach(t::add);
        return t;
    }
}
