package org.example.question1.category;

import org.example.question1.Board;

import java.util.ArrayList;
import java.util.List;

public class Category implements Search<Category>, Serializable {

    private final Category parent;
    private final String name;
    private final Board board;
    private final List<Category> children;

    public Category(Category parent, String name, Board board, List<Category> children) {
        this.parent = parent;
        this.name = name;
        this.board = board;
        this.children = children;
    }

    public Category(Category parent, String name, Board board) {
        this(parent, name, board, new ArrayList<>());
    }

    @Override
    public Category searchById(int id) {
        return searchById(this, id);
    }

    @Override
    public List<Category> searchByName(String name) {
        return null;
    }

    @Override
    public String convert() {
        return null;
    }

    public void addChild(Category child) {
        this.children.add(child);
    }

    private Category searchById(Category category, int id) {
        if (category.isBoardSameId(id)) {
            return category;
        } else {
            this.children.stream()
                    .filter(c -> c.searchById(c, id))
                    .findFirst()
        }
    }

    private boolean isBoardSameId(int id) {
        return this.board.isSameId(id);
    }
}
