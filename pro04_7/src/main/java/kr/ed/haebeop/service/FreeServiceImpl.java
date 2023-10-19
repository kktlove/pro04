package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.persistence.BoardMapper;
import kr.ed.haebeop.persistence.FreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeServiceImpl implements FreeService {

    @Autowired
    private FreeMapper freeMapper;

    @Override
    public List<Free> getFreeList1(int offset, int size) {
        List<Free> freeList = freeMapper.getFreeList1(offset, size);
        return freeList;
    }

    @Override
    public List<Free> getFreeList2(int offset, int size, String field, String query) {
        List<Free> freeList = freeMapper.getFreeList2(offset, size, field, query);
        return freeList;
    }

    @Override
    public int totalCount() {
        return freeMapper.totalCount();
    }

    @Override
    public int searchCount(String field, String query) {
        return freeMapper.searchCount(field, query);
    }

    @Override
    public Free getFree(int bno) {
        return freeMapper.getFree(bno);
    }

    @Override
    public void updateVisitedCount(int bno) {
        freeMapper.updateVisitedCount(bno);
    }

    @Override
    public void updateRecCount(int bno) { freeMapper.updateRecCount(bno); }

    @Override
    public void freeUpDate(Free free) {
        freeMapper.freeUpDate(free);
    }

    @Override
    public void freeDelete(int bno) {
        freeMapper.freeDelete(bno);
    }

    @Override
    public void freeInsert(Free free) {
        freeMapper.freeInsert(free);
    }
}
