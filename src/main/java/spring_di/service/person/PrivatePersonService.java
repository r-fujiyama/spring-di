package spring_di.service.person;

import org.springframework.stereotype.Service;
import spring_di.annotation.Private;
import spring_di.controller.Person;
import spring_di.enums.CustomerType;

@Private
@Service
public class PrivatePersonService implements PersonService {

    @Override
    public String getPersonInfo(Person person) {
        return "private " + person.getLastName() + " " + person.getFirstName() + " " + person.getAge();
    }

    @Override
    public CustomerType getCustomerType() {
        return CustomerType.PRIVATE;
    }
}
