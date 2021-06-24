package spring_di.utils;

import spring_di.enums.CustomerType;

import java.util.EnumMap;
import java.util.Map;

public class MapUtils {

    private MapUtils() {
    }

    public static <T> Map<CustomerType, T> createServiceMap(T privateService, T freelanceService, T corporateService) {
        Map<CustomerType, T> map = new EnumMap<>(CustomerType.class);
        map.put(CustomerType.PRIVATE, privateService);
        map.put(CustomerType.FREELANCE, freelanceService);
        map.put(CustomerType.CORPORATE, corporateService);
        return map;
    }
}
