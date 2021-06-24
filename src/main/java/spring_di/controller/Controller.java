package spring_di.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_di.enums.CustomerType;
import spring_di.service.customer.CustomerService;
import spring_di.service.person.PersonService;

@RestController
public class Controller {

    private final CustomerService customerService;
    private final PersonService personService;

    public Controller(CustomerService customerService, PersonService personService) {
        this.customerService = customerService;
        this.personService = personService;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String getCustomer() {
        return customerService.getCustomerInfo();
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String getPerson(@RequestBody Person person) {
        return personService.getPersonInfo(person);
    }

    @RequestMapping(value = "/person/type", method = RequestMethod.GET)
    public CustomerType getPersonType() {
        return personService.getCustomerType();
    }
}
