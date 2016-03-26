/**
 * Created by damirik on 08/02/16.
 */
class GarbageCar extends Auto implements CargoAuto, CleaningAuto {

    public void transportCargo() {
        System.out.println("Везу мусор");
    }


    public void transportClean() {
        System.out.println("Загружаю мусор");
    }
}
