import dto.Dish;
import dto.Human;
import dto.Restaurant;
import parser.impl.JaxbParser;
import parser.impl.JsonParser;
import parser.Parser;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        File jaxbFile = new File("src/main/resources/restaurant.xml") ;
        File jsonFile = new File("src/main/resources/restaurant.json") ;
        addItems(restaurant);
        addEmployee(restaurant);
        Parser jaxb = new JaxbParser();
        Parser json = new JsonParser();
        jaxb.convertTo(jaxbFile, restaurant);
        json.convertTo(jsonFile, restaurant);
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
