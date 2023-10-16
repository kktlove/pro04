import kr.ed.haebeop.config.RootConfig;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.sql.Connection;
@Log4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
@DisplayName("MyBatis 관련 테스트")
public class MyBatisTest {
    private SqlSessionFactory sqlSessionFactory;

    @Test
    @DisplayName("myBatis 연결 테스트")
    void myBatisTest() {
        try(SqlSession session = sqlSessionFactory.openSession();
            Connection connection = session.getConnection();){
            log.info(session);
            log.info(connection);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
