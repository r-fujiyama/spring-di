package spring_di.service.person;

import org.springframework.stereotype.Service;
import spring_di.annotation.Freelance;
import spring_di.controller.Person;
import spring_di.enums.CustomerType;

@Freelance
@Service
public class FreelancePersonService implements PersonService {

    @Override
    public String getPersonInfo(Person person) {
        return "freelance " + person.getLastName() + " " + person.getFirstName() + " " + person.getAge();
    }

    @Override
    public CustomerType getCustomerType() {
        return CustomerType.FREELANCE;
    }
}
