package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Test;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestMapperImpl {

    @Autowired
    private SqlSession sqlSession;

    public List<Test> getTestList() {
        return sqlSession.selectList("test.getTestList");
    }
}
