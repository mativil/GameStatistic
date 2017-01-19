package entity;

import javax.persistence.*;

/**
 * Created by Ivan on 19.01.2017.
 */
@Entity
@Table(name = "hero")
@NamedQueries({
        @NamedQuery(name = Hero.ALL_HEROES,
                query = "select h from Hero h"),
        @NamedQuery(name = Hero.FIND_BY_NAME,
                query = "select h from Hero h where h.name = :name")
})
public class Hero {
    public static final String ALL_HEROES = "Hero.allHeroes";
    public static final String FIND_BY_NAME = "Hero.findByName";

    /**
     * id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HERO_ID", insertable = false, updatable = false)
    private int id;

    /**
     * Логин пользователя
     * Должен быть уникальным
     */
    @Column(unique = true)
    private String name;

    @Column
    private String description;

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

}
