package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // EntityManger를 가져오기 위한 EntityManagerFactory 변수 선언
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // EntityManagerFactory에서 EntityManger를 가져온다.
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 얻어오기
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작
        tx.begin();

        try {
//            Member findMember = em.find(Member.class, 2L); // PK를 통해 member 조회
//            findMember.setName("HelloJPA");

            List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }
            
            // 트랜잭션 커밋
            tx.commit();
        } catch (Exception e) {
            // 예외 발생 시, 트랜잭션 롤백
            tx.rollback();
        } finally {
            em.close(); // 자원 정리
        }

        emf.close(); // 자원 정
    }
}
