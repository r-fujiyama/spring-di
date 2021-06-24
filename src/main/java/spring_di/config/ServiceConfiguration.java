package spring_di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring_di.annotation.Corporate;
import spring_di.annotation.Freelance;
import spring_di.annotation.Private;
import spring_di.enums.CustomerType;
import spring_di.service.customer.CustomerService;
import spring_di.utils.MapUtils;
import spring_di.utils.ReflectUtils;

import java.util.Map;

@Configuration
public class ServiceConfiguration {

    @Bean
    @Primary
    public CustomerService customerService(@Private CustomerService privateService,
                                           @Freelance CustomerService freelanceService,
                                           @Corporate CustomerService corporateService) {
        Map<CustomerType, CustomerService> serviceMap = MapUtils.createServiceMap(privateService, freelanceService, corporateService);
        return ReflectUtils.newProxy(CustomerService.class, serviceMap);
    }
}
