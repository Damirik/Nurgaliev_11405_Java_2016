/**
 * Created by damirik on 08/02/16.
 */
class Truck extends Auto implements CargoAuto {
    final static int a = 1;
    public void transportCargo() {
        System.out.println("Везу груз");
    }
}