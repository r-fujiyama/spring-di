package spring_di.service.customer;

import org.springframework.stereotype.Service;
import spring_di.TransactionInfo;
import spring_di.annotation.Freelance;

@Freelance
@Service
public class FreelanceCustomerService implements CustomerService {

    @Override
    public String getCustomerInfo() {
        return "freelance customer:" + TransactionInfo.getCustomerNo();
    }
}
