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
    private TeamEntity winTeam;
    @OneToOne(targetEntity = TeamEntity.class, fetch = FetchType.LAZY)
    private TeamEntity loseTeam;

    protected LogEntity() {
    }

    public LogEntity(TeamEntity winTeam, TeamEntity loseTeam) {
        this.winTeam = winTeam;
        this.loseTeam = loseTeam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TeamEntity getwinTeam() {
        return winTeam;
    }

    public void setwinTeam(TeamEntity winTeam) {
        this.winTeam = winTeam;
    }

    public TeamEntity getloseTeam() {
        return loseTeam;
    }

    public void setloseTeam(TeamEntity loseTeam) {
        this.loseTeam = loseTeam;
    }
}
