package kr.ed.haebeop.config;
//주입 설정 및 빈 등록 파일 : ApplicationConfig.java
import kr.ed.haebeop.repository.TestRepository;
import kr.ed.haebeop.repository.TestRepositoryImpl;
import kr.ed.haebeop.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

//컨트롤러나 서비스, 맴퍼, 레포시토리에서 사용할 Bean을 등록
@Configuration
@ComponentScan(basePackages = "kr.ed.haebeop")
public class ApplicationConfig {
    @Bean
    public TestService testService(){ return new TestServiceImpl(); }
    @Bean
    public TestRepository testRepository(){ return new TestRepositoryImpl(); }
    @Bean
    public MemberService memberService(){ return new MemberServiceImpl(); }
    @Bean
    public BoardService boardService() { return new BoardServiceImpl(); }

}