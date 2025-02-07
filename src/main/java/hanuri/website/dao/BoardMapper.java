package hanuri.website.dao;

import hanuri.website.domain.dto.Board.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void save(Board board);
    List<Board> findAll();
    Optional<Board> findById(@Param("id") int id);
    void modify(Board board);
    List<Board> findForHome(int limit);
}
