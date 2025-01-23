package hanuri.website.dao;

import hanuri.website.domain.dto.Board.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void save(Board board);
    List<Board> findAll();
    Optional<Board> findById(int id);
    void modify(Board board);
}
