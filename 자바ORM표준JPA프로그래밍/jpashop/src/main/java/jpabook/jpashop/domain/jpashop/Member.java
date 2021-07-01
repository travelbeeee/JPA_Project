package jpabook.jpashop.domain.jpashop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
public class Member {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    protected Member(){}

    public Member(String name) {
        this.name = name;
    }
}
