import BreadthFirstSearch.Map;
import Entities.Coordinates;

public class RenderConsoleMap {
    public void render(Map map){
        for (int i = 0; i < Map.ROW; i++) {
            for (int j = 0; j < Map.COL; j++) {
                Coordinates currCoordinate = new Coordinates(i,j);
                if (map.isCoordinateEmpty(currCoordinate)){
                    System.out.print("\uD83D\uDFEB");
                }
                else{
                    System.out.print(map.getEntity(currCoordinate).toString());
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
    }

}
