package org.example.question1;

import java.util.List;

public interface Category<T> {
    T searchById(int id);
    List<T> searchByName(String name);
    void addLast(T element);
}
