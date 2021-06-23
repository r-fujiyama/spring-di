package spring_di.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import spring_di.enums.CustomerType;
import spring_di.TransactionInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TransactionInfoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String customerType = request.getHeader("customer-type");
        if (customerType == null || customerType.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String customerNo = request.getHeader("customer-no");
        if (customerNo == null || customerNo.isEmpty()) {
            throw new IllegalArgumentException();
        }
        TransactionInfo.init(CustomerType.valueOf(customerType), customerNo);
        return true;
    }
}