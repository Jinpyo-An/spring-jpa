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

//            List<Member> result = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속
//            em.persist(member);
//
//            final Member findMember = em.find(Member.class, 101L);
//            System.out.println("findmember.getId() = " + findMember.getId());
//            System.out.println("findmember.getName() = " + findMember.getName());

//            final Member findMember1 = em.find(Member.class, 101L);
//            final Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("result = " + (findMember1 == findMember2));

//            final Member member1 = new Member(150L, "A");
//            final Member member2 = new Member(160L, "B");
//            System.out.println("=================");
//
//            em.persist(member1);
//            em.persist(member2);

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAA");

            // 영속 -> 준영속 상태로 변경
//            em.detach(member);

            // 엔티티 매니저의 영속성 모두 지우기
//            em.clear();
//            Member member2 = em.find(Member.class, 150L);
//
//
//
//            System.out.println("=================");

//            final Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();

//            final Member member = new Member();
//            member.setName("C");
//
//            em.persist(member);

//            final Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            final Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            final Member findMember = em.find(Member.class, member.getId());
//
//            final Long findTeamId = findMember.getTeamId();
//            final Team findTeam = em.find(Team.class, findTeamId);

//            final Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            final Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            final Member findMember = em.find(Member.class, member.getId());
//
//            final Team findTeam = findMember.getTeam();
//            System.out.println("findTeam.getId() = " + findTeam.getId());

            final Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            final Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);

//            em.flush();
//            em.clear();

            final Team findTeam = em.find(Team.class, team.getId());
            final List<Member> members = findTeam.getMembers();

            for (Member m : members) {
                System.out.println("m = " + m.getUsername());
            }

//            final Member findMember = em.find(Member.class, member.getId());
//            final List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }



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
