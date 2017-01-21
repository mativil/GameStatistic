package entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;

/**
 * Created by Ivan on 19.01.2017.
 */
@Entity
@Table(name = "`character`")

public class CharacterEntity {

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

    @OneToOne(targetEntity = CharacterTypeEntity.class)
    CharacterTypeEntity type;

    public CharacterEntity() {
    }

    public CharacterEntity(String name, CharacterTypeEntity type) {
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

}
