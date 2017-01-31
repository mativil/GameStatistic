package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21.01.2017.
 */
@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private boolean isWin;

    @OneToMany(targetEntity = HeroStatisticEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "team")
    private
    List<HeroStatisticEntity> HeroestatisticEntityList;

    @ManyToOne(targetEntity = LogEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private
    LogEntity log;

    public TeamEntity() {
    }

    public TeamEntity(LogEntity log) {
        this.log = log;
    }

    public TeamEntity(List<HeroStatisticEntity> HeroestatisticEntityList) {
        this.HeroestatisticEntityList = HeroestatisticEntityList;
    }

    public int getId() {
        return id;
    }

    public List<HeroStatisticEntity> getHeroestatisticEntityList() {
        return HeroestatisticEntityList;
    }

    public void setHeroestatisticEntityList(List<HeroStatisticEntity> HeroestatisticEntityList) {
        this.HeroestatisticEntityList = HeroestatisticEntityList;
    }

    public boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(boolean isWin) {
        this.isWin = isWin;
    }

    public LogEntity getLog() {
        return log;
    }

    public void setLog(LogEntity log) {
        this.log = log;
    }
}
