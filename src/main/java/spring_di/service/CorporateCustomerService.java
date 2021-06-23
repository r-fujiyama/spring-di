package spring_di.service;

import org.springframework.stereotype.Service;
import spring_di.TransactionInfo;
import spring_di.annotation.Corporate;

@Corporate
@Service
public class CorporateCustomerService implements CustomerService {

    @Override
    public String getCustomerInfo() {
        return "corporate: " + TransactionInfo.getCustomerNo();
    }
}
