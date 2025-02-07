package hanuri.website.service;

import hanuri.website.dao.BoardMapper;
import hanuri.website.domain.EBoardCategory;
import hanuri.website.domain.dto.Board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Board> findOne(int id) {
        return boardMapper.findById(id);
    }

    public void modify(Board board) {
        boardMapper.modify(board);
    }

    public List<Board> findForHome(int limit) {
        return boardMapper.findForHome(limit);
    }

    public List<Board> findWithCategory(int categoryId) {
        return boardMapper.findWithCategory(categoryId);
    }
}
