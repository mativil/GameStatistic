package entity;

import javax.persistence.*;

/**
 * Created by Ivan on 21.01.2017.
 */
@Entity
@Table(name = "characterStatistic")
public class CharacterStatisticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(targetEntity = CharacterEntity.class, fetch = FetchType.EAGER)
    private CharacterEntity characterEntity;

    @OneToOne(targetEntity = PlayerEntity.class, fetch = FetchType.EAGER)
    private PlayerEntity playerEntity;

    @Column
    private int killsCount;

    @Column
    private int deathsCount;

    @ManyToOne( targetEntity = TeamEntity.class, fetch = FetchType.EAGER)
    TeamEntity team;

    protected CharacterStatisticEntity() {
    }

    public CharacterStatisticEntity(CharacterEntity characterEntity, PlayerEntity playerEntity, int killsCount, int deathsCount) {

        this.characterEntity = characterEntity;
        this.playerEntity = playerEntity;
        this.killsCount = killsCount;
        this.deathsCount = deathsCount;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CharacterEntity getcharacterEntity() {
        return characterEntity;
    }

    public void setcharacterEntity(CharacterEntity characterEntity) {
        this.characterEntity = characterEntity;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public int getKillsCount() {
        return killsCount;
    }

    public void setKillsCount(int killsCount) {
        this.killsCount = killsCount;
    }

    public int getDeathsCount() {
        return deathsCount;
    }

    public void setDeathsCount(int deathsCount) {
        this.deathsCount = deathsCount;
    }
}
