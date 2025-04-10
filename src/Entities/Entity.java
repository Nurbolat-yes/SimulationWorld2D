package Entities;

public abstract class Entity {
    protected String texture;
    private Coordinates coordinates;

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public String toString(){
        return this.texture;
    }

}
