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

    @OneToMany(targetEntity = CharacterStatisticEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "team")
    private
    List<CharacterStatisticEntity> characterStatisticEntityList;

    protected TeamEntity() {
    }

    public TeamEntity(List<CharacterStatisticEntity> characterStatisticEntityList) {
        this.characterStatisticEntityList = characterStatisticEntityList;
    }

    public int getId() {
        return id;
    }

    public List<CharacterStatisticEntity> getCharacterStatisticEntityList() {
        return characterStatisticEntityList;
    }
}
