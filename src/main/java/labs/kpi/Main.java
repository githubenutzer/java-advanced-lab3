package labs.kpi;

import labs.kpi.models.*;
import labs.kpi.validators.Validator;
import labs.kpi.sqlgenerator.SQLGenerator;

/**
 * Main class to demonstrate object validation and SQL generation.
 *
 * @author Oleksii Kyrychenko
 */
public class Main {

    public static void main(String[] args) {
        try {
            User user = new User("customer_username", "CustomerPassword1234", 20);
            Article article = new Article("Laptop", 40000, 10);
            Order order = new Order("ORD-2024-12-00001", 1, 40000);

            Validator.validate(user);
            Validator.validate(article);
            Validator.validate(order);

            System.out.println(SQLGenerator.generateSQL(User.class));
            System.out.println(SQLGenerator.generateSQL(Article.class));
            System.out.println(SQLGenerator.generateSQL(Order.class));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
