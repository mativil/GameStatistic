package entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ivan on 19.01.2017.
 */
@Entity
@Table(name = "`Hero`")

public class HeroEntity implements Comparable{

    /**
     * id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", insertable = false, updatable = false)
    private int id;

    /**
     * Логин пользователя
     * Должен быть уникальным
     */
    @Column(unique = true)
    private String name;

    @Column
    private String description;

    public HeroTypeEntity getType() {
        return type;
    }

    @ManyToOne(targetEntity = HeroTypeEntity.class, fetch = FetchType.EAGER)
    HeroTypeEntity type;

    @OneToMany(targetEntity = HeroStatisticEntity.class,
            fetch = FetchType.EAGER,
            mappedBy = "HeroEntity")
    List<HeroStatisticEntity> heroStatInfo;

    public List<HeroStatisticEntity> getHeroStatInfo() {
        return heroStatInfo;
    }

    public void setHeroStatInfo(List<HeroStatisticEntity> heroStatInfo) {
        this.heroStatInfo = heroStatInfo;
    }

    public HeroEntity() {
    }

    public HeroEntity(String name, HeroTypeEntity type) {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String login)
    {
        this.name = login;
    }

    public int getId()
    {
        return id;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public int compareTo(Object o) {
        return this.id - ((HeroEntity)o).getId();
    }
}
