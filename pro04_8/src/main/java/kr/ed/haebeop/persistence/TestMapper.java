package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;
//Mapper 인터페이스 + MyBatis Mapper
//test2Mapper.xml의 안의 namespace 속성에 kr.ed.haebeop.persistence.TestMapper
//test2Mapper.xml의 안의 명령 tag 의 id와 kr.ed.haebeop.persistence.TestMapper의 메소드명이 일치
//ApplicationConfig에 Bean 등록 하지 안함.
@Mapper
public interface TestMapper {
    public List<Test> getTestList2();
    public Test getTest2(int num);
    public void insert2(Test test);
    public void update2(Test test);
    public void delete2(int num);
}