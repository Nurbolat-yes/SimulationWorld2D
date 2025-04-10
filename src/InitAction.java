import BreadthFirstSearch.Map;
import Entities.*;

public class InitAction extends Action {

    public InitAction(Map map){
        super.map = map;
    }

    @Override
    public void perform() {
        // set grass
        setGrass();

        // set Rock
        setRock();

        // set Tree
        setTree();

        //set Predator
        setPredator();

        // set Herbibove
        setHerbivore();

    }

    public void setGrass() {
        for (int i = 0 ; i < persentForGrass ; i++){
            Coordinates emptyCell = getEmptyCell();
            map.setEntity(emptyCell,new Grass(emptyCell.getX(),emptyCell.getY()));
        }
    }

    public void setRock() {
        for (int i = 0; i < persentForRock; i++) {
            Coordinates emptyCell = getEmptyCell();
            map.setEntity(emptyCell,new Rock());
        }
    }

    public void setTree() {
        for (int i = 0; i < persentForTree; i++) {
            Coordinates emptyCell = getEmptyCell();
            map.setEntity(emptyCell,new Tree());
        }
    }

    public void setPredator() {
        for (int i = 0; i < persentForPredator; i++) {
            Coordinates emptyCell = getEmptyCell();
            map.setEntity(emptyCell,new Predator(emptyCell.getX(), emptyCell.getY()));
        }
    }

    public void setHerbivore(){
        for (int i = 0; i < persentForHerbivore; i++) {
            Coordinates emptyCell = getEmptyCell();
            map.setEntity(emptyCell,new Herbivore(emptyCell.getX(), emptyCell.getY()));
        }
    }


}
