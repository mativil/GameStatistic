package org.mativil.entity;

import javax.persistence.*;

/**
 * Created by MI on 03.02.2017.
 */
@Entity
@Table(name = "account")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="email", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column (name = "salt", columnDefinition = "varchar(20)", nullable = false)
    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Column(name = "password", columnDefinition = "varchar(100)", nullable = false)
    private String password;
}
