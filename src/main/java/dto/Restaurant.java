package dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Restaurant {

    @XmlElementWrapper(name = "menu")
    @XmlElement(name = "dish")
    private List<Dish> menu = new ArrayList();

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Human> employee = new ArrayList();

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public List<Human> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Human> employee) {
        this.employee = employee;
    }

    public void hireEmployee(Human human) {
        employee.add(human);
    }

    public void addDish(Dish dish) {
        menu.add(dish);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", employee=" + employee +
                '}';
    }
}
