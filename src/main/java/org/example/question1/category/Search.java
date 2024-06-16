package org.example.question1.category;

import java.util.List;

public interface Search<T> {
    List<T> searchById(int id);
    List<T> searchByName(String name);
}
