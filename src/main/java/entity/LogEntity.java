package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ivan on 21.01.2017.
 */
@Entity
@Table(name = "log")
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(targetEntity = TeamEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "log")
    private
    List<TeamEntity> teamList;

    public LogEntity() {
    }

    public LogEntity(List<TeamEntity> teamList) {
        this.teamList = teamList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TeamEntity> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<TeamEntity> teamList) {
        this.teamList = teamList;
    }
}
