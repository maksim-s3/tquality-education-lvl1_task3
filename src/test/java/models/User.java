package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int salary;
    private String department;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.getFirstName())&&lastName.equals(user.getLastName())&&email.equals(user.getEmail())&&
                age==user.getAge()&&salary== user.getSalary()&&department.equals(user.getDepartment());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime* Objects.hash(firstName, lastName, email, age, salary, department);
    }
}
