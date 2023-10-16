package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.persistence.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> getBoardList1(int offset, int size) {
        List<Board> boardList = boardMapper.getBoardList1(offset, size);
        return boardList;
    }

    @Override
    public List<Board> getBoardList2(int offset, int size, String field, String query) {
        List<Board> boardList = boardMapper.getBoardList2(offset, size, field, query);
        return boardList;
    }
}
