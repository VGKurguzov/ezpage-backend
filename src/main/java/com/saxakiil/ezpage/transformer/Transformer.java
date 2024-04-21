package com.saxakiil.ezpage.transformer;

public interface Transformer<T,V> {

    V toObject(T t);

    V merge(V v, T t);
}
