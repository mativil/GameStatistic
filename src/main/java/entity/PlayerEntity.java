package entity;

import javax.persistence.*;

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

}
