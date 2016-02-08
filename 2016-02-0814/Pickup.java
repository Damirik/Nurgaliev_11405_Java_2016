/**
 * Created by damirik on 08/02/16.
 */
class Pickup implements CargoAuto, PassangersAuto {
    public void transportCargo() {
        System.out.println("Везу груз");
    }
    public void transportPassangers() {
        System.out.println("Везу пассажиров");
    }
}