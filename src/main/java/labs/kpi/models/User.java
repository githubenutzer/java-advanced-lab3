package labs.kpi.models;

import labs.kpi.annotations.MaxValue;
import labs.kpi.annotations.MinValue;
import labs.kpi.annotations.NotNull;
import labs.kpi.annotations.StringLength;

/**
 * Represents a user with username, password, and age.
 *
 * @author Oleksii Kyrychenko
 */
public class User {
    @NotNull
    private String username;

    @StringLength(min = 3, max = 20)
    private String password;

    @MinValue(18)
    @MaxValue(99)
    private Integer age;

    public User(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}