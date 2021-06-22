package Brothersoo.hellospringtutorial;

import Brothersoo.hellospringtutorial.repository.JdbcMemberRepository;
import Brothersoo.hellospringtutorial.repository.MemberRepository;
import Brothersoo.hellospringtutorial.service.MemberService;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private final DataSource dataSource;
  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
    return new JdbcMemberRepository(dataSource);
  }
}
