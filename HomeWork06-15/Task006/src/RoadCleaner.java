/**
 * Created by damirik on 08/02/16.
 */
public class RoadCleaner extends Auto implements CleaningAuto {
    @Override
    public void transportClean() {
        System.out.println("Чищу дорогу");
    }
}
