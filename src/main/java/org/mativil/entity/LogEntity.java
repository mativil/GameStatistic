package org.mativil.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    private List<TeamEntity> teamList;

    @ManyToOne(targetEntity = MapEntity.class, fetch = FetchType.EAGER)
    MapEntity map;

    @Column(name ="lodatime")
    private LocalDateTime loadTime;

    @Column
    private LocalTime duration;

    public LogEntity() {
    }

    public LogEntity(List<TeamEntity> teamList) {
        this.teamList = teamList;
    }

    public LogEntity(MapEntity map, LocalDateTime loadTime, LocalTime duration) {
        this.map = map;
        this.loadTime = loadTime;
        this.duration = duration;
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

    public MapEntity getMap() {
        return map;
    }

    public void setMap(MapEntity map) {
        this.map = map;
    }

    public LocalDateTime getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(LocalDateTime loadTime) {
        this.loadTime = loadTime;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
