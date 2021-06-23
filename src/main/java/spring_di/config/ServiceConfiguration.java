package spring_di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring_di.TransactionInfo;
import spring_di.annotation.Corporate;
import spring_di.annotation.Freelance;
import spring_di.annotation.Private;
import spring_di.service.CustomerService;

import java.lang.reflect.Proxy;

@Configuration
public class ServiceConfiguration {

    @Bean
    @Primary
    public CustomerService customerService(@Private CustomerService privateService,
                                           @Freelance CustomerService freelanceService,
                                           @Corporate CustomerService corporateService) {
        return newProxy(CustomerService.class, privateService, freelanceService, corporateService);
    }

    private <T> T newProxy(Class<T> clazz, T privateService, T freelanceService, T corporateService) {
        Object object = Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, (proxy, method, args) -> {
            switch (TransactionInfo.getCustomerType()) {
                case PRIVATE:
                    return method.invoke(privateService, args);
                case FREELANCE:
                    return method.invoke(freelanceService, args);
                case CORPORATE:
                    return method.invoke(corporateService, args);
                default:
                    throw new IllegalArgumentException("CustomerType is unexpected");
            }
        });
        return clazz.cast(object);
    }
}
