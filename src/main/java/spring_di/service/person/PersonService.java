package spring_di.service.person;

import spring_di.controller.Person;
import spring_di.enums.CustomerType;

public interface PersonService {

    String getPersonInfo(Person person);

    CustomerType getCustomerType();
}
