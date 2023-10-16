package kr.ed.haebeop.repository;

import kr.ed.haebeop.domain.Test;

import java.util.List;

public interface TestRepository {
    public List<Test> getTestList();
    public Test getTest(int num);
    public void insert(Test test);
    public void update(Test test);
    public void delete(int num);
}
