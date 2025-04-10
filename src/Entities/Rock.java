package Entities;

public class Rock extends Entity {

    private final String unicode = "\uD83E\uDEA8";

    public Rock(){
        super.texture = unicode;
    }

    @Override
    public String toString() {
        return texture;
    }
}
