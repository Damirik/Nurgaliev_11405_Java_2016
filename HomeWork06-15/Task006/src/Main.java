import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by Дамир on 25.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Auto> autos = new ArrayList<Auto>();
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        for (int i = 0; i < 10; i++){
            autos.add((CowTruck) ac.getBean("CowTruck"));
        }
        for (int i = 0; i < 10; i++){
            autos.add((FastTaxi) ac.getBean("fastTaxi"));
        }
        for (int i = 0; i < 10; i++){
            autos.add((Truck) ac.getBean("truck"));
        }
        for (int i = 0; i < 10; i++){
            autos.add((Pickup) ac.getBean("pickup"));
        }
        for (int i = 0; i < 10; i++){
            autos.add((Sedan) ac.getBean("sedan"));
        }
        for (int i = 0; i < 10; i++){
            autos.add((GarbageCar) ac.getBean("GarbageCar"));
        }

    }
}