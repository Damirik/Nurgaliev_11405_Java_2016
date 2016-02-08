/**
 * Created by damirik on 08/02/16.
 */
public class CowTruck implements AnimalAuto, CargoAuto {
    @Override
    public void transportAnimal() {
        System.out.println("Везу коров");
    }

    @Override
    public void transportCargo() {
        System.out.println("Везу груз");

    }
}
