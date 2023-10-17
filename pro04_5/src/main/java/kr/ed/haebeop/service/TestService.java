package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Test;
import kr.ed.haebeop.persistence.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TestService {
    public List<Test> getTestList();
    public List<Test> getTestList2();
    public List<Test> getTestList3();
    public Test getTest(int num);
    public Test getTest2(int num);
    public Test getTest3(int num);
    public void insert(Test test);
    public void insert2(Test test);
    public void insert3(Test test);
    public void update(Test test);
    public void update2(Test test);
    public void update3(Test test);
    public void delete(int num);
    public void delete2(int num);
    public void delete3(int num);
}
