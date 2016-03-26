/**
 * Created by damirik on 08/02/16.
 */
class Pickup extends Auto implements CargoAuto, PassangersAuto {
    public void transportCargo() {
        System.out.println("Везу груз");
    }
    public void transportPassangers() {
        System.out.println("Везу пассажиров");
    }
}