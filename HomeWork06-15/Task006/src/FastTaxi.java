/**
 * Created by damirik on 08/02/16.
 */
public class FastTaxi extends Auto implements SportAuto,PassangersAuto {
    @Override
    public void transportPassangers() {
        System.out.println("Везу пассажиров");
    }

    @Override
    public void transportSport() {
        System.out.println("Еду гонку");

    }
}
