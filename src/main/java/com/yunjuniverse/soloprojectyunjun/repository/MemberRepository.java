package com.yunjuniverse.soloprojectyunjun.repository;

import com.yunjuniverse.soloprojectyunjun.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    default List<Member> test(int size, int page) {
        EntityManager em = null;
        return em.createNativeQuery(String.valueOf(Member.class)).setFirstResult(page*size).setMaxResults(size).getResultList();
    }
}
