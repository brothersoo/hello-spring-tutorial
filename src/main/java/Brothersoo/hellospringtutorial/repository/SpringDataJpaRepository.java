package Brothersoo.hellospringtutorial.repository;

import Brothersoo.hellospringtutorial.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaRepository extends JpaRepository<Member, Long>, MemberRepository {

  @Override
  Optional<Member> findByName(String name);
}
