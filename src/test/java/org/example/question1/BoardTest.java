package org.example.question1;

import org.example.question1.category.Category;
import org.example.question1.category.CategoryBuilder;
import org.example.question1.category.Search;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.question1.category.CategoryBuilder.*;

class BoardTest {

    private final Search<Category> root = makeFixture();

    @Test
    void searchById() {
        System.out.println(root);
    }

    private Category makeFixture() {
        final List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "1번 게시글", "1번 게시글"));

        final Board 익명게시판 = new Board(8, posts);

        final CategoryElement 엑소 = CategoryElement.of("엑소", 2)
                .add(CategoryElement.of("공지사항", 3))
                .add(CategoryElement.of("첸", 4))
                .add(CategoryElement.of("백현", 5));
        final CategoryElement 방탄소년단 = CategoryElement.of("방탄소년단", 6)
                .add(CategoryElement.of("공지사항", 7))
                .add(CategoryElement.of("익명게시판", 익명게시판))
                .add(CategoryElement.of("뷔", 9));
        final CategoryElement 남자 = CategoryElement.of("남자", 1)
                .add(엑소)
                .add(방탄소년단);

        final CategoryElement 블랙핑크 = CategoryElement.of("블랙핑크", 11)
                .add(CategoryElement.of("공지사항", 12))
                .add(CategoryElement.of("익명게시판", 익명게시판))
                .add(CategoryElement.of("로제", 13));
        final CategoryElement 여자 = CategoryElement.of("여자", 10)
                .add(블랙핑크);

        return new CategoryBuilder()
                .add(남자)
                .add(여자)
                .build();
    }
}
