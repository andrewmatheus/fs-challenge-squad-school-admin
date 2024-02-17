package Testing;

import classes.Director;
import classes.Employee;
import classes.IEmployee;
import classes.Teacher;
public class promotion {
    public static void main(String[] args) {
        IEmployee employee = new Employee("Fulano", 3000.0, 2);
        System.out.println("Antes da promoção: " + employee);
        employee.promotion();
        System.out.println("promoção: " + employee);
        employee.promotion();
        System.out.println("promoção: " + employee); //2 promotions

        System.out.println("\n");

        IEmployee teacher = new Teacher("Beltrano", 30, 4000.0, 3);
        System.out.println("Antes da promoção: " + teacher);
        teacher.promotion();
        System.out.println("promoção: " + teacher); //1 promotions

        System.out.println("\n");

        IEmployee director = new Director("Carinha que mora logo ali", 5000.0, 5);
        System.out.println("Antes da promoção: " + director);
        director.promotion();
        director.promotion();
        director.promotion();
        System.out.println("promoção: " + director); // 3 promotions
    }
}
