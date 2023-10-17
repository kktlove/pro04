package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.domain.Free;

import java.util.List;

public interface FreeService {
    public List<Free> getFreeList1(int offset, int size);
    public List<Free> getFreeList2(int offset, int size, String field, String query);
    public int totalCount();
    public int searchCount(String field, String query);
    public Free getFree(int bno);
    public void updateVisitedCount(int bno);
    public void updateRecCount(int bno);
    public void freeUpDate(Free free);
    public void freeDelete(int bno);
    public void freeInsert(Free free);
}
