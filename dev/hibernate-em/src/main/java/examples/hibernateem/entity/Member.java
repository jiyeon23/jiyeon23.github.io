package examples.hibernateem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity // member라는 테이블 생성
//@Table(name=테이블이름)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 id 생성
    @Column(name = "MEMBER_ID") // primary키
    private Long id;

    private String name;

    @Embedded // 컬럼이 멤버테이블에 생김
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
