package BreadthFirstSearch;

import Entities.*;

import java.util.*;

public class Bfs {
    private static List<Coordinates> path = new ArrayList<>();

    public List<Coordinates> findWayToResource(Map map, Coordinates start, Coordinates end, Creature creature){
        Queue<List<Coordinates>> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        queue.add(new ArrayList<>(List.of(start)));
        visited.add(start);

        int[] dX = {-1,1,0,0};
        int[] dY = {0,0,-1,1};

        while (!queue.isEmpty()){
            List<Coordinates> currPath = queue.poll();
            Coordinates node = currPath.get(currPath.size() - 1);

            if (node.equals(end)){
                return currPath;
            }

            //System.out.println(currPath);

            for (int i = 0 ; i < 4 ;i++ ){
                Coordinates newCoord = new Coordinates(node.getX() + dX[i], node.getY() + dY[i]);
                if (newCoord.getX() >= 0 && newCoord.getX() < Map.ROW &&
                    newCoord.getY() >= 0 && newCoord.getY() < Map.COL &&
                    !visited.contains(newCoord) &&
                    map.isCoordinateEmpty(newCoord,creature) ||
                        (creature instanceof Herbivore && map.getEntity(newCoord) instanceof Grass) ||
                        (creature instanceof Predator && map.getEntity(newCoord) instanceof Herbivore)
                )
                {
                    List<Coordinates> newPath = new ArrayList<>(currPath);
                    newPath.add(newCoord);
                    queue.add(newPath);
                    visited.add(newCoord);
                }
            }
        }
        return null;
    }

}

