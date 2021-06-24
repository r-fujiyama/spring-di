package spring_di.service.person;

import org.springframework.stereotype.Service;
import spring_di.annotation.Corporate;
import spring_di.controller.Person;
import spring_di.enums.CustomerType;

@Corporate
@Service
public class CorporatePersonService implements PersonService {

    @Override
    public String getPersonInfo(Person person) {
        return "corporate " + person.getLastName() + " " + person.getFirstName() + " " + person.getAge();
    }

    @Override
    public CustomerType getCustomerType() {
        return CustomerType.CORPORATE;
    }
}
