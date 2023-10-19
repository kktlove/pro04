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

    @Override
    public int totalCount() {
        return boardMapper.totalCount();
    }

    @Override
    public int searchCount(String field, String query) {
        return boardMapper.searchCount(field, query);
    }

    @Override
    public Board getBoard(int bno) {
        return boardMapper.getBoard(bno);
    }

    @Override
    public void updateVisitedCount(int bno) {
        boardMapper.updateVisitedCount(bno);
    }

    @Override
    public void boardUpDate(Board board) {
        boardMapper.boardUpDate(board);
    }

    @Override
    public void boardDelete(int bno) {
        boardMapper.boardDelete(bno);
    }

    @Override
    public void boardInsert(Board board) {
        boardMapper.boardInsert(board);
    }
}
