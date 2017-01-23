package entity;

import javax.persistence.*;

/**
 * Created by Ivan on 21.01.2017.
 */
@Entity
@Table(name = "HeroType")
public class HeroTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    public HeroTypeEntity() {
    }

    public HeroTypeEntity(String name) {
        this.name = name;
    }
}
