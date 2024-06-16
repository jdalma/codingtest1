package org.example.question1;

import org.example.question1.category.Category;
import org.example.question1.category.CategoryBuilder;
import org.example.question1.category.Search;
import org.example.question1.category.Serializable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.example.question1.category.CategoryBuilder.*;

class CategoryTest {

    private final Search<Category> root = makeFixture();

    @Test
    @DisplayName("searchById 메서드는 동일한 id를 가진 Cateoory들을 반환한다.")
    void searchById() {
        List<Category> categories = root.searchById(12);

        assertThat(categories.size()).isEqualTo(1);
        assertThat(categories.get(0).getName()).isEqualTo("공지사항");
    }

    @Test
    @DisplayName("익명게시판은 서로 다른 Category이지만, 동일한 Board이다.")
    void reference() {
        List<Category> categories = root.searchById(8);

        assertThat(categories.size()).isEqualTo(2);
        assertThat(categories.get(0)).isNotEqualTo(categories.get(1));
        assertThat(categories.get(0).getBoard()).isEqualTo(categories.get(1).getBoard());
        assertThat(categories.get(0).getName()).isEqualTo("익명게시판");
        assertThat(categories.get(1).getName()).isEqualTo("익명게시판");
    }

    @Test
    @DisplayName("searchByName 메서드는 검색 단어를 포함한 이름을 가진 Cateoory들을 반환한다.")
    void searchByName() {
        List<Category> categories = root.searchByName("자");

        assertThat(categories.size()).isEqualTo(2);
        assertThat(categories.get(0).getName()).isEqualTo("남자");
        assertThat(categories.get(1).getName()).isEqualTo("여자");
    }

    @Test
    @DisplayName("Category를 JSON 구조로 변경할 수 있다.")
    void toJSON() throws IOException {
        Serializable category = (Serializable) root;

        String actual = category.convert().trim();
        String expect = read("category.json").trim();

        assertThat(actual).isEqualTo(expect);
    }

    private String read(String fileName) throws IOException {
        return Files.readString(Paths.get("src/test/resources/" + fileName));
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
