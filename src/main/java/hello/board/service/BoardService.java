package hello.board.service;

import hello.board.entity.Board;
import hello.board.entity.User;
import hello.board.repository.BoardRepository;
import hello.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    /**
     * 게시글 생성
     */
    @Transactional
    public Long register(String title, String content, Long userId) {
        User user = userRepository.findOne(userId).orElseThrow();

        Board board = Board.createBoard(title, content, user);
        boardRepository.save(board);
        return board.getId();
    }

    /**
     * 게시판 전체 조회
     */
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    /**
     * 게시글 단건 조회
     */
    public Optional<Board> findOne(Long id) {
        return boardRepository.findById(id);
    }

    /**
     * 게시글 수정
     */
    @Transactional
    public void updateBoard(Long id, String title, String content) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.update(title, content);
    }

    /**
     * 게시글 삭제
     */
    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
