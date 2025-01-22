package hanuri.website.service;

import hanuri.website.dao.BoardMapper;
import hanuri.website.domain.dto.Board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    /// 저장
    public void save(Board board) {
        boardMapper.save(board);
    }

    /// 조회
    public List<Board> findAll() {
        return boardMapper.findAll();
    }

}
