package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ivan on 21.01.2017.
 */
@Entity
@Table(name = "HeroType")
public class HeroTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(targetEntity = HeroEntity.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "type")
    List<HeroEntity> heroes;

    public List<HeroEntity> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<HeroEntity> heroes) {
        this.heroes = heroes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Column(unique = true)
    private String name;

    public HeroTypeEntity() {
    }

    public HeroTypeEntity(String name) {
        this.name = name;
    }
}
