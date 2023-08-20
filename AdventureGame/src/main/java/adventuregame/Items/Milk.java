package adventuregame.items;


public class Milk extends Item {
    public Milk() {
        this.name = "Milk";
        this.description = "A carton of milk. Boring and bland.";
    }

    @Override
    public boolean use() {
        System.out.println("You drank the milk.");
        return true;
    }
}
