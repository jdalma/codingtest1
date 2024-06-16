package org.example.question1.category;

import org.example.question1.Board;

import java.util.ArrayList;
import java.util.List;

public class CategoryBuilder {
    private final Category root = new Category(null, "ROOT", new Board(0));
    private final List<CategoryElement> rootChildren = new ArrayList<>();

    public CategoryBuilder add(CategoryElement element) {
        rootChildren.add(element);
        return this;
    }

    public Category build() {
        for (CategoryElement child : rootChildren) {
            root.addChild(elementBuild(root, child));
        }
        return root;
    }

    private Category elementBuild(Category parent, CategoryElement element) {
        Category category = new Category(parent, element.name, element.board);
        for (CategoryElement child : element.children) {
            category.addChild(elementBuild(category, child));
        }
        return category;
    }

    public static class CategoryElement {
        private final String name;
        private final Board board;
        private final List<CategoryElement> children;

        public static CategoryElement of(String name, int id) {
            return new CategoryElement(name, new Board(id), new ArrayList<>());
        }

        public static CategoryElement of(String name, Board board) {
            return new CategoryElement(name, board, new ArrayList<>());
        }

        private CategoryElement(String name, Board board, List<CategoryElement> children) {
            this.name = name;
            this.board = board;
            this.children = children;
        }

        public CategoryElement add(CategoryElement element) {
            this.children.add(element);
            return this;
        }
    }
}
