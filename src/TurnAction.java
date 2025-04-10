import BreadthFirstSearch.Map;
import Entities.*;

import java.util.ArrayList;
import java.util.List;

public class TurnAction extends Action{
    private List<Herbivore> herbivores = new ArrayList<>();
    private List<Predator> predators = new ArrayList<>();
    private List<Grass> grasses = new ArrayList<>();

    public TurnAction(Map map){
        super.map = map;
    }

    @Override
    public void perform() {
            searchOfEntities();

            if (grasses.size() < persentForGrass){
                setGrass();
            }

            if (herbivores.size() < persentForHerbivore){
                setHerbivore();
            }

            if (predators.size() < persentForPredator){
                setPredator();
            }

            for (Herbivore h : herbivores){
                h.makeMove(map);
                System.out.println("Hp " + h +" : "+ h.getHp());
            }
            for (Predator p : predators){
                p.makeMove(map);
            }

            grasses.clear();
            herbivores.clear();
            predators.clear();

    }

    @Override
    public void setGrass() {
        for (int i = grasses.size() ; i < persentForGrass ; i++){
            Coordinates emptyCell = getEmptyCell();
            map.setEntity(emptyCell,new Grass(emptyCell.getX(),emptyCell.getY()));
        }
    }

    @Override
    public void setHerbivore() {
        for (int i = herbivores.size(); i < persentForHerbivore; i++) {
            Coordinates emptyCell = getEmptyCell();
            map.setEntity(emptyCell,new Herbivore(emptyCell.getX(), emptyCell.getY()));
        }
    }

    @Override
    public void setPredator() {
        for (int i = predators.size() ; i < persentForPredator ; i++){
            Coordinates emptyCell = getEmptyCell();
            map.setEntity(emptyCell,new Predator(emptyCell.getX(),emptyCell.getY()));
        }
    }


    public void searchOfEntities(){
        for (int i = 0; i < Map.ROW; i++) {
            for (int j = 0; j < Map.COL; j++) {
                Coordinates curr = new Coordinates(i,j);
                if (!map.isCoordinateEmpty(curr)){
                    if (map.getEntity(curr) instanceof Herbivore){
                        Herbivore herbivore = (Herbivore) map.getEntity(curr);
                        herbivores.add(herbivore);

                    } else if (map.getEntity(curr) instanceof Predator) {
                        Predator predator  = (Predator) map.getEntity(curr);
                        predators.add(predator);

                    } else if (map.getEntity(curr) instanceof Grass) {
                        Grass grass = (Grass) map.getEntity(curr);
                        grasses.add(grass);

                    }
                }
            }
        }
    }
}
