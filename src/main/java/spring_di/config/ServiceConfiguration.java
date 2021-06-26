package spring_di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring_di.TransactionInfo;
import spring_di.annotation.Corporate;
import spring_di.annotation.Freelance;
import spring_di.annotation.Private;
import spring_di.enums.CustomerType;
import spring_di.service.customer.CustomerService;
import spring_di.utils.MapUtils;

import java.lang.reflect.Proxy;
import java.util.Map;

@Configuration
public class ServiceConfiguration {

    @Bean
    @Primary
    public CustomerService customerService(@Private CustomerService privateService,
                                           @Freelance CustomerService freelanceService,
                                           @Corporate CustomerService corporateService) {
        Map<CustomerType, CustomerService> serviceMap = MapUtils.createServiceMap(privateService, freelanceService, corporateService);
        return newProxy(CustomerService.class, serviceMap);
    }

    private static <T> T newProxy(Class<T> clazz, Map<CustomerType, T> serviceMap) {
        var object = Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz},
                (proxy, method, args) -> method.invoke(serviceMap.get(TransactionInfo.getCustomerType()), args));
        return clazz.cast(object);
    }
}
