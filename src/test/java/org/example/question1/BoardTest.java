package org.example.question1;

import org.junit.jupiter.api.Test;

import static org.example.question1.BoardBuilder.*;

class BoardTest {

    private final Category<Board> root = makeFixture();

    @Test
    void searchById() {
        System.out.println(root);
    }

    private Board makeFixture() {
        final BoardElement 익명게시판 = BoardElement.of(8, "익명게시판");

        final BoardElement 엑소 = BoardElement.of(2, "엑소")
                .add(BoardElement.of(3, "공지사항"))
                .add(BoardElement.of(4, "첸"))
                .add(BoardElement.of(5, "백현"));
        final BoardElement 방탄소년단 = BoardElement.of(6, "방탄소년단")
                .add(BoardElement.of(7, "공지사항"))
                .add(익명게시판)
                .add(BoardElement.of(9, "뷔"));
        final BoardElement 남자 = BoardElement.of(1, "남자")
                .add(엑소)
                .add(방탄소년단);

        final BoardElement 블랙핑크 = BoardElement.of(11, "블랙핑크")
                .add(BoardElement.of(12, "공지사항"))
                .add(익명게시판)
                .add(BoardElement.of(13, "로제"));
        final BoardElement 여자 = BoardElement.of(10, "여자")
                .add(블랙핑크);

        return new BoardBuilder()
                .add(남자)
                .add(여자)
                .build();
    }
}
