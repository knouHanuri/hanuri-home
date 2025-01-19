package hanuri.website.dao;

import hanuri.website.domain.dto.Board.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void save(Board board);
    List<Board> findAll();
}
