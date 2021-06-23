package spring_di.enums;

public enum CustomerType {

    PRIVATE("1"),
    FREELANCE("2"),
    CORPORATE("3");

    private final String value;

    CustomerType(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }

}
