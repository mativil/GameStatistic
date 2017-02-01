package org.mativil.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ivan on 21.01.2017.
 */
@Entity
@Table(name = "player")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;

    @OneToMany(targetEntity = HeroStatisticEntity.class,
            fetch = FetchType.EAGER,
            mappedBy = "playerEntity")
    List<HeroStatisticEntity> heroStatInfo;

    public PlayerEntity() {
    }

    public PlayerEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HeroStatisticEntity> getHeroStatInfo() {
        return heroStatInfo;
    }

    public void setHeroStatInfo(List<HeroStatisticEntity> heroStatInfo) {
        this.heroStatInfo = heroStatInfo;
    }
}
