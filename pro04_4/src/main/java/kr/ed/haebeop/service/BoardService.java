package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Board;

import java.util.List;

public interface BoardService {
    public List<Board> getBoardList1(int offset, int size);
    public List<Board> getBoardList2(int offset, int size, String field, String query);
}
