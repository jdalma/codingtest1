package org.example.question1.category;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.example.question1.Board;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Category implements Search<Category>, Serializable {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new SimpleModule().addSerializer(Category.class, new CategorySerializer()))
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
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
    public List<Category> searchById(int id) {
        return search((Category c) -> c.isSameId(id), new ArrayList<>());
    }

    @Override
    public List<Category> searchByName(String name) {
        return search((Category c) -> c.isContainName(name), new ArrayList<>());
    }

    @Override
    public String convert() {
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void addChild(Category child) {
        this.children.add(child);
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public List<Category> getChildren() {
        return children;
    }

    private List<Category> search(Predicate<Category> condition, List<Category> result) {
        if (condition.test(this)) {
            result.add(this);
        }
        for (Category child : this.children) {
            child.search(condition, result);
        }
        return result;
    }

    private boolean isSameId(int id) {
        return this.board.isSameId(id);
    }

    private boolean isContainName(String name) {
        return this.name.contains(name);
    }
}
