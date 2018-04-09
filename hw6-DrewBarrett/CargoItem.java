/**
 * CargoItem
 */
public class CargoItem extends Cargo {
    private int weight;
    private int height;

    public CargoItem(String id, int weight, int height) {
        super(id);
        this.weight = weight;
        this.height = height;
    }

    public String toString() {
        return super.toString() + ":\t"
            + "Weight: " + weight
            + "\tHeight: " + height;
    }
    
}