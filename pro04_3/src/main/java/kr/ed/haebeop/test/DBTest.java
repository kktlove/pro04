import kr.ed.haebeop.config.RootConfig;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
@DisplayName("DB 관련 테스트")
public class DBTest {
    //private static final Logger logger = LoggerFactory.getLogger(DBTest.class);

    private DataSource dataSource;

    @Autowired
    public DBTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Test
    @DisplayName("Hikari 설정 테스트")
    void datasourceTest() {
        try(Connection connection = dataSource.getConnection()){
            log.info(connection);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
