package org.example.question1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Board implements Category<Board>, Serializable {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final Board parent;
    private final String name;
    private final BoardIdentifier id;
    private final List<Board> children;

    private Board(Board parent, String name, BoardIdentifier boardIdentifier, List<Board> children) {
        this.parent = parent;
        this.name = name;
        this.id = boardIdentifier;
        this.children = children;
    }

    public Board(Board parent, String name, int id) {
        this(parent, name, new BoardIdentifier(id), new ArrayList<>());
    }

    @Override
    public Board searchById(int id) {

        return null;
    }

    @Override
    public List<Board> searchByName(String name) {
        return null;
    }

    @Override
    public void addLast(Board element) {
        this.children.add(element);
    }

    @Override
    public String convert() {
        return null;
    }
}
