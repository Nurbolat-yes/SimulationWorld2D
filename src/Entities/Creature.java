package Entities;

import BreadthFirstSearch.Map;

import java.util.List;

public abstract class Creature extends Entity {
    int speed;
    int Hp;
    private List<Coordinates> wayToResource;

    public List<Coordinates> getWayToResource() {
        return wayToResource;
    }

    public void setWayToResource(List<Coordinates> wayToResource) {
        this.wayToResource = wayToResource;
    }

    public int getHp(){
        return Hp;
    }

    public void setHp(int hp){
        this.Hp = hp;
    }

    public abstract void makeMove(Map map);

}
