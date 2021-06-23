package spring_di;

import spring_di.enums.CustomerType;

public class TransactionInfo {

    private static final ThreadLocal<ThreadVo> threadLocal = new ThreadLocal<>();

    public static void init(CustomerType customerType, String customerNo) {
        ThreadVo vo = new ThreadVo(customerType, customerNo);
        threadLocal.set(vo);
    }

    public static void unbind() {
        threadLocal.remove();
    }

    public static CustomerType getCustomerType() {
        checkInitialized();
        return threadLocal.get().getCustomerType();
    }

    public static String getCustomerNo() {
        checkInitialized();
        return threadLocal.get().getCustomerNo();
    }

    public static boolean isInitialized() {
        return threadLocal.get() != null;
    }

    private static void checkInitialized() {
        if (!isInitialized()) {
            throw new IllegalThreadStateException();
        }
    }

    private static class ThreadVo {

        ThreadVo(CustomerType customerType, String customerNo) {
            this.customerType = customerType;
            this.customerNo = customerNo;
        }

        private final CustomerType customerType;
        private final String customerNo;

        public CustomerType getCustomerType() {
            return this.customerType;
        }

        public String getCustomerNo() {
            return this.customerNo;
        }
    }

}
