package hellojpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

//    @OneToOne
//    @JoinColumn(name = "locker_id")
//    private Locker locker;


    public Member() {
    }

//    @Column(name = "team_id")
//    private Long teamId;

//    @ManyToOne
//    @JoinColumn(name = "team_id")

//    private Team team;

//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
