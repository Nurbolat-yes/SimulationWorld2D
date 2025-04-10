package Entities;


import BreadthFirstSearch.Bfs;
import BreadthFirstSearch.Map;

import java.util.LinkedList;
import java.util.List;

public class Predator extends Creature {
    private final int strength = 2;
    private final String unicode = "\uD83E\uDD81";
    private Bfs bfs = new Bfs();
    private List<Coordinates> way = new LinkedList<>();

    public Predator(int x,int y){
        super.setCoordinates(new Coordinates(x,y));
        super.speed = 1;
        super.Hp = 6;
        super.texture = unicode;
    }

    @Override
    public void makeMove(Map map) {

        if (way.isEmpty()){
            Herbivore target = findNearestHerbivore(map);
            if (target != null){
                way = bfs.findWayToResource(map,this.getCoordinates(),target.getCoordinates(),this);
            }
        }

        for (int i = 0; i < speed; i++) {
            if (way != null && !way.isEmpty()){

                Coordinates nextStep = way.remove(0);
                Entity entity = map.getEntity(nextStep);

                if (entity instanceof Predator){
                    return;
                }
                if (entity instanceof Herbivore){
                    Herbivore herbivore = (Herbivore) entity;
                    attack(herbivore);
                    if (herbivore.getHp() <= 0){
                        map.removeEntity(nextStep);
                    }
                    return;
                }

                map.removeEntity(this.getCoordinates());
                this.setCoordinates(nextStep);
                map.setEntity(nextStep,this);
            }
        }
    }

    public Herbivore findNearestHerbivore(Map map){
        Herbivore nearest = null;
        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < Map.ROW; i++) {
            for (int j = 0; j < Map.COL; j++) {
                Coordinates curr = new Coordinates(i,j);
                if (map.getEntity(curr) instanceof Herbivore){
                    int dist = Math.abs(this.getCoordinates().getX() - i) - Math.abs(this.getCoordinates().getY() - j);
                    if (dist < minDis){
                        minDis = dist;
                        nearest = (Herbivore) map.getEntity(curr);
                    }
                }
            }
        }
        return nearest;
    }



    public void attack(Herbivore herbivore){
        herbivore.setHp(herbivore.getHp() - strength);
    }

    @Override
    public String toString() {
        return texture;
    }
}
