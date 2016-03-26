/**
 * Created by damirik on 08/02/16.
 */
public class CowTruck extends Auto implements CargoAuto, AnimalAuto  {



    @Override
    public void transportAnimal() {
        System.out.println("Везу коров");
    }

    @Override
    public void transportCargo() {
        System.out.println("Везу груз");

    }
}
