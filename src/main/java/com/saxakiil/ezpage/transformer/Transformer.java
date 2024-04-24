package com.saxakiil.ezpage.transformer;

public interface Transformer<T,V> {

    V toObject(T t);

    T toDto(V v);

    V merge(V v, T t);
}
