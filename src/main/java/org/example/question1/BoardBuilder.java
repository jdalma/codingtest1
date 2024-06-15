package org.example.question1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardBuilder {
    private final Board root = new Board(null, "ROOT", 0);
    private final List<BoardElement> rootChildren = new ArrayList<>();

    public BoardBuilder add(BoardElement element) {
        rootChildren.add(element);
        return this;
    }

    public Board build() {
        for (BoardElement child : rootChildren) {
            root.addLast(elementBuild(root, child));
        }
        return root;
    }

    private Board elementBuild(Board parent, BoardElement element) {
        Board board = new Board(parent, element.name, element.id);
        for (BoardElement child : element.children) {
            board.addLast(elementBuild(board, child));
        }
        return board;
    }

    public static class BoardElement {
        private final int id;
        private final String name;
        private final List<BoardElement> children;

        public static BoardElement of(int id, String name) {
            return new BoardElement(id, name, new ArrayList<>());
        }

        private BoardElement(int id, String name, List<BoardElement> children) {
            this.id = id;
            this.name = name;
            this.children = children;
        }

        public BoardElement add(BoardElement element) {
            this.children.add(element);
            return this;
        }
    }
}
