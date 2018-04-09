/**
 * Boxcar
 */
import java.util.ArrayList;
public class Boxcar<T extends Cargo> {
    private int capacity;
    private ArrayList<T> cargo;
    private String cargoType;

    public Boxcar(int capacity, String cargoType) {
        this.capacity = capacity;
        this.cargoType = cargoType;
        cargo = new ArrayList();
    }

    public void printCargo() {
        for (Cargo item : cargo) {
            System.out.println("\t\t" + item.toString());
        }
    }

    public void load(String type, T input) throws Exception {
        // Throw error if we are full
        if (cargo.size() == capacity) {
            throw new Exception("ERROR: Not enough room to add item");
        }
        // Throw error if we are wrong type
        if (!type.equals(cargoType)) {
            throw new Exception("ERROR: You cannot add a " + type + " to a "
                + cargoType + " boxcar");
        }
        cargo.add(input);
    }

    public void unload(String id) throws Exception {
        // If thing does not exist throw error
        if (!remove(id)) {
            throw new Exception("ERROR: Item with id does not exist.");
        }
    }

    public boolean isDuplicate(Cargo givenItem) {
        for (Cargo item : cargo) {
            if (givenItem.getId().equals(item.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(String id) {
        for (Cargo item : cargo) {
            if (id.equals(item.getId())) {
                cargo.remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return cargo.size() == 0;
    }
}