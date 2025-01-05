package hanuri.website.dao;

import hanuri.website.domain.dto.Board.Board;

import java.util.List;
import java.util.Optional;

public interface BoardMapper {
    void save(Board board);

    Optional<Board> findById(int boardId);

    List<Board> findAll();

    void modify(Board board);

}
