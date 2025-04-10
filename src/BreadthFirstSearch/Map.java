package BreadthFirstSearch;

import Entities.*;

import java.util.HashMap;

public class Map {
    public static final int ROW = 16;
    public static final int COL = 16;
    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntity(Coordinates coordinates,Entity entity){
        entities.put(coordinates,entity);
    }

    public boolean isCoordinateEmpty(Coordinates coordinates){
        if (entities.get(coordinates) == null){
            return true;
        }
        return false;
    }

    public boolean isCoordinateEmpty(Coordinates coordinates,Creature creature){
        Entity entity = entities.get(coordinates);

        if (entity == null) return true;

        if (creature instanceof Herbivore){
            return entity instanceof Grass;
        }
        else if (creature instanceof Predator) {
            return entity instanceof Herbivore;
        }

        return false;
    }

    public Entity getEntity(Coordinates coordinates){
        return entities.get(coordinates);
    }

    public HashMap getEntities(){
        return entities;
    }

    public void removeEntity(Coordinates coordinates){
        entities.remove(coordinates);
    }

}
