package org.example.question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {
    private final int id;
    private final List<Post> posts;

    public Board(int id, List<Post> posts) {
        this.id = id;
        this.posts = posts;
    }

    public Board(int id) {
        this(id, new ArrayList<>());
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public boolean isSameId(int id) {
        return this.id == id;
    }
}
