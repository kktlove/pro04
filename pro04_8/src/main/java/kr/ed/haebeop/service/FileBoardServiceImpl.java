package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.AttachVO;
import kr.ed.haebeop.domain.FileBoard;
import kr.ed.haebeop.persistence.AttachMapper;
import kr.ed.haebeop.persistence.FileBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FileBoardServiceImpl implements FileBoardService {

    @Autowired
    private FileBoardMapper fileBoardMapper;

    @Autowired
    private AttachMapper attachMapper;


    @Override
    public List<FileBoard> getFileBoardList() {
        return fileBoardMapper.getFileBoardList();
    }

    @Override
    public FileBoard getFileBoard(int num) {
        return fileBoardMapper.getFileBoard(num);
    }

    @Override
    public List<AttachVO> getFileList(int num) {
        return attachMapper.getFileList(num);
    }

    @Override
    public int nextBoardNum() {
        return fileBoardMapper.nextBoardNum();
    }

    @Override
    public void register(FileBoard fileBoard) {
        fileBoardMapper.register(fileBoard);
    }

    @Override
    public void registerAttaches(FileBoard fileBoard, List<AttachVO> attachList) {
        for(AttachVO vo:attachList){
            attachMapper.insertAttach(vo);
        }
    }

    @Override
    public int lastBoardNum() {
        return fileBoardMapper.lastBoardBum();
    }

    @Transactional
    @Override
    public void updateFileBoard(FileBoard fileBoard, List<AttachVO> attachList) {
        fileBoardMapper.updateFileBoard(fileBoard);
        for(AttachVO attach: attachList) {
            attachMapper.updateAttach(attach);
        }
    }

    @Transactional
    @Override
    public void deleteFileBoard(int num) {
        fileBoardMapper.deleteFileBoard(num);
        attachMapper.deleteAttach(num);
    }

    @Override
    public void updateReadCount(int num) {
        fileBoardMapper.updateReadCount(num);
    }

    @Override
    public List<FileBoard> getBoardList1(int offset, int size) {
        return fileBoardMapper.getBoardList1(offset, size);
    }

    @Override
    public int totalCount() {
        return fileBoardMapper.totalCount();
    }

    @Override
    public List<FileBoard> getBoardList2(int offset, int size, String field, String query) {
        return fileBoardMapper.getBoardList2(offset, size, field, query);
    }

    @Override
    public int searchCount(String field, String query) {
        return fileBoardMapper.searchCount(field, query);
    }

    @Override
    public List<FileBoard> getFileBoardList2(int offset, int size, String field, String query) {
        return fileBoardMapper.getBoardList2(offset, size, field, query);
    }
}
