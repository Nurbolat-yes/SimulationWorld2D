import BreadthFirstSearch.Map;
import Entities.Coordinates;

import java.util.Random;

public abstract class Action {
    protected Map map;
    protected int area = Map.ROW * Map.COL;
    protected Random random = new Random();

    protected int persentForRock = (int)(area * 0.09);
    protected int persentForTree = (int)(area * 0.09);

    protected int persentForGrass = (int)(area * 0.015);
    protected int persentForHerbivore = (int)(area * 0.015);
    protected int persentForPredator = (int)(area * 0.015);

    public abstract void perform();

    public abstract void setGrass();
    public abstract void setHerbivore();
    public abstract void setPredator();

    public Coordinates getEmptyCell(){
        Coordinates checkCoordinate;
        while (true){
            int x = random.nextInt(Map.ROW);
            int y = random.nextInt(Map.COL);
            checkCoordinate = new Coordinates(x,y);
            if (map.isCoordinateEmpty(checkCoordinate)){
                return checkCoordinate;
            }
        }
    }

}
