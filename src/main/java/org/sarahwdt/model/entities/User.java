package org.sarahwdt.model.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "rating")
    private double rating;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games;

    public User() {

    }


    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.games = new LinkedList<>();
        this.rating = 0;
    }

    public void addGame(Game game){
        game.setUser(this);
        games.add(game);
    }

    public void setGames(List<Game> games){
        this.games = games;
    }

    public List<Game> getGames(){
        return games;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(name, user.name)) return false;
        return Objects.equals(password, user.password);
    }

    @Override
    public String toString() {
        return "entities.main.java.User{" +
                "id=" + Id +
                ", name='" + name +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0) + Id * 81;
        return result;
    }
}
