package hellojpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "team_id",insertable = false, updatable = false)
    private Team team;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

//    @Column(name = "team_id")
//    private Long teamId;

//    @ManyToOne
//    @JoinColumn(name = "team_id")
//    private Team team;

    public Member() {
    }

//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
