package spring_di.service.person;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import spring_di.annotation.Corporate;
import spring_di.annotation.Freelance;
import spring_di.annotation.Private;
import spring_di.controller.Person;
import spring_di.enums.CustomerType;
import spring_di.utils.MapUtils;
import spring_di.utils.ReflectUtils;

import java.util.Map;

@Primary
@Service
public class PersonServiceProxy implements PersonService {

    private final Map<CustomerType, PersonService> personServiceMap;

    public PersonServiceProxy(@Private PersonService privatePersonService,
                              @Freelance PersonService freelancePersonService,
                              @Corporate PersonService corporatePersonService) {
        this.personServiceMap = MapUtils.createServiceMap(
                privatePersonService, freelancePersonService, corporatePersonService);
    }

    @Override
    public String getPersonInfo(Person person) {
        var method = ReflectUtils.getMethod(PersonService.class, "getPersonInfo", person.getClass());
        return (String) ReflectUtils.methodInvoke(personServiceMap, method, person);
    }

    @Override
    public CustomerType getCustomerType() {
        var method = ReflectUtils.getMethod(PersonService.class, "getCustomerType");
        return (CustomerType) ReflectUtils.methodInvoke(personServiceMap, method);
    }

}
