package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.AttachVO;
import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.domain.FileBoard;

import java.util.List;

public interface FileBoardService {
    public List<FileBoard> getFileBoardList();
    public FileBoard getFileBoard(int num);
    public List<AttachVO> getFileList(int num);
    public int nextBoardNum();
    public void register(FileBoard fileBoard);
    public void registerAttaches(FileBoard fileBoard, List<AttachVO> attachList);
    public int lastBoardNum();
    public void updateFileBoard(FileBoard fileBoard, List<AttachVO> attachList);
    public void deleteFileBoard(int num);
    public void updateReadCount(int num);
    public List<FileBoard> getBoardList1(int offset, int size);
    public int totalCount();
    public List<FileBoard> getBoardList2(int offset, int size, String field, String query);
    public int searchCount(String field, String query);
    public List<FileBoard> getFileBoardList2(int offset, int size, String field, String query);
}
