package hello.board.service;

import hello.board.entity.Board;
import hello.board.repository.BoardRepository;
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

    @Transactional
    public Long save(Board board) {
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
     * 게시글 삭제
     */
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
