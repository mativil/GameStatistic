package entity;

import javax.persistence.*;

/**
 * Created by Ivan on 21.01.2017.
 */
@Entity
@Table(name = "characterType")
public class CharacterTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    public CharacterTypeEntity() {
    }

    public CharacterTypeEntity(String name) {
        this.name = name;
    }
}
