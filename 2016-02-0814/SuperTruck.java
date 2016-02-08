/**
 * Created by damirik on 08/02/16.
 */
public class SuperTruck implements AnimalAuto, PassangersAuto,CargoAuto {
    @Override
    public void transportAnimal() {
        System.out.println("Везу животных");
    }

    @Override
    public void transportCargo() {
        System.out.println("Везу груз");

    }

    @Override
    public void transportPassangers() {
        System.out.println("Везу пассажиров");

    }
}
