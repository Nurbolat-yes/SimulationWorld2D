package Entities;

import BreadthFirstSearch.Bfs;
import BreadthFirstSearch.Map;

import java.util.LinkedList;
import java.util.List;

public class Herbivore extends Creature {
    private final String unicode = "\uD83D\uDC07";
    private Bfs bfs = new Bfs();
    private List<Coordinates> way = new LinkedList<>();

    public Herbivore(int x, int y){
        super.setCoordinates(new Coordinates(x,y));
        super.speed = 1;
        super.Hp = 4;
        super.texture = unicode;
    }

    @Override
    public void makeMove(Map map) {

        if (way.isEmpty()){
            Grass target = findNearestGrass(map);
            if (target != null){
                way = bfs.findWayToResource(map,this.getCoordinates(),target.getCoordinates(),this);
            }
        }

        for (int i = 0; i < speed; i++) {
            if (way != null && !way.isEmpty()){

                Coordinates nextStep = way.remove(0);
                Entity entity = map.getEntity(nextStep);

                if (entity instanceof Herbivore){
                    return;
                }
                if (entity instanceof Grass){
                    map.removeEntity(nextStep);
                }

                map.removeEntity(this.getCoordinates());
                this.setCoordinates(nextStep);
                map.setEntity(nextStep,this);
            }
        }
    }

    public Grass findNearestGrass(Map map){
        Grass nearest = null;
        int minDis = Integer.MAX_VALUE;

        for (int i = 0 ; i < Map.ROW; i++){
            for (int j = 0; j < Map.COL; j++) {
                Coordinates curr = new Coordinates(i,j);
                if (map.getEntity(curr) instanceof Grass){
                    int dist = Math.abs(this.getCoordinates().getX() - i) - Math.abs(this.getCoordinates().getY() - j);
                    if (dist < minDis){
                        minDis = dist;
                        nearest = (Grass) map.getEntity(curr);
                    }
                }
            }
        }
        return nearest;
    }

    @Override
    public String toString() {
        return texture;
    }
}
