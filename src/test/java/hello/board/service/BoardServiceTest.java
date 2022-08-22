package hello.board.service;

import hello.board.entity.Board;
import hello.board.entity.User;
import hello.board.repository.BoardRepository;
import hello.board.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;
    @Autowired EntityManager em;

    @Test
    public void register() {
        //given
        User user = User.builder().loginId("userA").build();
        em.persist(user);

        //when
        Long registerId = boardService.register("AAA", "BBB", user.getId());

        //then
        Board board = boardRepository.findById(registerId).orElseThrow();

        assertThat(board.getTitle()).isEqualTo("AAA");
        assertThat(board.getContent()).isEqualTo("BBB");
        assertThat(board.getUser()).isEqualTo(user);
    }

    @Test
    public void updateBoard() {
        //given
        User user = User.builder().loginId("userA").build();
        em.persist(user);
        Long registerId = boardService.register("AAA", "BBB", user.getId());

        //when
        boardService.updateBoard(registerId, "CCC", "DDD");

        //then
        Board board = boardRepository.findById(registerId).orElseThrow();

        assertThat(board.getTitle()).isEqualTo("CCC");
        assertThat(board.getContent()).isEqualTo("DDD");
        assertThat(board.getUser()).isEqualTo(user);
    }
}