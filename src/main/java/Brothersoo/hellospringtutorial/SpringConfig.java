package Brothersoo.hellospringtutorial;

import Brothersoo.hellospringtutorial.repository.MemberRepository;
import Brothersoo.hellospringtutorial.repository.MemoryMemberRepository;
import Brothersoo.hellospringtutorial.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  @Bean
  public MemberService memberSerivce() {
    return new MemberService(memberRepository());
  }
}
