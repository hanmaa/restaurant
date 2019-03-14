import dto.Dish;
import dto.Human;
import dto.Restaurant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        addItems(restaurant);
        addEmployee(restaurant);
        try {
            JAXBContext context = JAXBContext.newInstance(Restaurant.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(restaurant, new File("src/main/resources/restaurant.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void addItems(Restaurant restaurant) {
        Dish roastBeef = new Dish("roast beef", 380);
        Dish duckMeat = new Dish("duck meat", 550);
        Dish greekSalad = new Dish("greek salad", 300);
        Dish mushroomSoup = new Dish("mushroom soup", 320);

        restaurant.addDish(roastBeef);
        restaurant.addDish(duckMeat);
        restaurant.addDish(greekSalad);
        restaurant.addDish(mushroomSoup);
    }

    private static void addEmployee(Restaurant restaurant) {
        Human Alex = new Human(1, "Alex", "Smith", "director", 25);
        Human Bob = new Human(2, "Bob", "Johnson", "waiter", 27);
        Human Carl = new Human(3, "Carl", "Jones", "chef", 29);
        Human Donald = new Human(4, "Donald", "Brown", "waiter",22);
        Human Ricardo = new Human(5, "Ricardo", "Millos", "dishwasher", 30);

        restaurant.hireEmployee(Alex);
        restaurant.hireEmployee(Bob);
        restaurant.hireEmployee(Carl);
        restaurant.hireEmployee(Donald);
        restaurant.hireEmployee(Ricardo);
    }
}
