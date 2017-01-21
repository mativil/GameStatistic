package entity;

import javax.persistence.*;

/**
 * Created by Ivan on 21.01.2017.
 */
@Entity
@Table(name = "log")
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(targetEntity = TeamEntity.class, fetch = FetchType.LAZY)
    private TeamEntity team1;
    @OneToOne(targetEntity = TeamEntity.class, fetch = FetchType.LAZY)
    private TeamEntity team2;

    protected LogEntity() {
    }

    public LogEntity(TeamEntity team1, TeamEntity team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TeamEntity getTeam1() {
        return team1;
    }

    public void setTeam1(TeamEntity team1) {
        this.team1 = team1;
    }

    public TeamEntity getTeam2() {
        return team2;
    }

    public void setTeam2(TeamEntity team2) {
        this.team2 = team2;
    }
}
