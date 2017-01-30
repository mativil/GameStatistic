package entity;

import javax.persistence.*;

/**
 * Created by Ivan on 21.01.2017.
 */
@Entity
@Table(name = "HeroStatistic")
public class HeroStatisticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = HeroEntity.class, fetch = FetchType.EAGER)
    private HeroEntity HeroEntity;

    @ManyToOne(targetEntity = PlayerEntity.class, fetch = FetchType.EAGER)
    private PlayerEntity playerEntity;

    @ManyToOne(targetEntity = TeamEntity.class, fetch = FetchType.EAGER)
    private TeamEntity team;

    @Column
    private int killsCount;

    @Column
    private int deathsCount;

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }



    protected HeroStatisticEntity() {
    }

    public HeroStatisticEntity(HeroEntity HeroEntity, PlayerEntity playerEntity, int killsCount, int deathsCount, TeamEntity team) {

        this.HeroEntity = HeroEntity;
        this.playerEntity = playerEntity;
        this.killsCount = killsCount;
        this.deathsCount = deathsCount;
        this.team = team;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HeroEntity getHeroEntity() {
        return HeroEntity;
    }

    public void setHeroEntity(HeroEntity HeroEntity) {
        this.HeroEntity = HeroEntity;
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
