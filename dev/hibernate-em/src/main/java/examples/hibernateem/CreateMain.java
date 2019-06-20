package examples.hibernateem;

import examples.hibernateem.entity.Address;
import examples.hibernateem.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("member-unit");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작

// todo

            Member member = new Member();
            member.setName("kang");
            member.setAddress(new Address("Goyang","wicity","10321"));

            em.persist(member); //insert 영속 상태

            member.setName("고지연");
            member.setName("ko");

            Member member2 = new Member();
            member2.setName("kim");
            member2.setAddress(new Address("seoul","scity","10000"));

            em.persist(member2);

            //find 에서 엔티티 만 먼저 찾고 , 엔티티에 없으면 db로 가서 찾아옴
            em.remove(em.find(Member.class,2L));



            //모든 쿼리 날리지 않고 마지막에

            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

}
