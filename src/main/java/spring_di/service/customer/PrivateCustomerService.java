package spring_di.service.customer;

import org.springframework.stereotype.Service;
import spring_di.TransactionInfo;
import spring_di.annotation.Private;

@Private
@Service
public class PrivateCustomerService implements CustomerService {

    @Override
    public String getCustomerInfo() {
        return "private customer:" + TransactionInfo.getCustomerNo();
    }
}
