package Entities;

public class Tree extends Entity {
    private final String unicode = "\uD83C\uDF33";

    public Tree(){
        super.texture = unicode;
    }

    @Override
    public String toString() {
        return texture;
    }
}
