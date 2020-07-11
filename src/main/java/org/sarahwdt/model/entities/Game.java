package org.sarahwdt.model.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MoveData> moveData;

    @Column(name = "secret")
    public String secret;
    @Column(name = "result")
    private boolean result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Game(){

    }

    public Game(String secret, boolean result) {
        this.secret = secret;
        this.moveData = new LinkedList<>();
        this.result = result;
    }

    public void addMoveData(MoveData data){
        data.setGame(this);
        this.moveData.add(data);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MoveData> getMoveData() {
        return moveData;
    }

    public void setMoveData(List<MoveData> moveData) {
        this.moveData = moveData;
    }

    public String getSecret(){
        return this.secret;
    }

    public void setSecret(String secret){
        this.secret = secret;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
