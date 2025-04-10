package Entities;

public class Grass extends Entity {
    private final String unicode = "\uD83C\uDF31";

    public Grass(int x, int y){
        super.setCoordinates(new Coordinates(x,y));
        super.texture = unicode;
    }

    @Override
    public String toString() {
        return texture;
    }
}
