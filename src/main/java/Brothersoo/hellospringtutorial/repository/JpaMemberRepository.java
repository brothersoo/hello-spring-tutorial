package Brothersoo.hellospringtutorial.repository;

import Brothersoo.hellospringtutorial.domain.Member;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JpaMemberRepository implements MemberRepository{

  private final EntityManager em;

  public JpaMemberRepository(EntityManager enityManager) {
    this.em = enityManager;
  }

  @Override
  public Member save(Member member) {
    em.persist(member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    Member result = em.find(Member.class, id);
    return Optional.ofNullable(result);
  }

  @Override
  public Optional<Member> findByName(String name) {
    List result = em.createQuery("select m from Member m where m.name = :name")
        .setParameter("name", name)
        .getResultList();
    return result.stream().findAny();
  }

  @Override
  public List<Member> findAll() {
    return em.createQuery("select m from Member m", Member.class).getResultList();
  }
}
