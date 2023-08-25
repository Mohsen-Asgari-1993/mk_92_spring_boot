package ir.maktabsharif92.springboot.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SecurityInformationUtil {

    public static final Map<String, Set<String>> rolePermissionMap = new HashMap<>();

    public static final String ADMIN_ROLE = "admin";
    public static final String CUSTOMER_ROLE = "customer";

    public static final String CUSTOMER_CREATE = "customer:create";
    public static final String CUSTOMER_UPDATE = "customer:update";
    public static final String CUSTOMER_READ_ALL = "customer:readall";
    public static final String CUSTOMER_READ = "customer:read";
    public static final String CUSTOMER_DELETE = "customer:delete";

    public static final String ABOUT_US_UPDATE = "aboutus:update";
    public static final String ABOUT_US_READ = "aboutus:read";

    static {

        rolePermissionMap.put(
                ADMIN_ROLE,
                Set.of(
                        CUSTOMER_CREATE,
                        CUSTOMER_UPDATE,
                        CUSTOMER_READ_ALL,
                        CUSTOMER_READ,
                        CUSTOMER_DELETE,
                        ABOUT_US_UPDATE,
                        ABOUT_US_READ
                )
        );

        rolePermissionMap.put(
                CUSTOMER_ROLE,
                Set.of()
        );

    }

}
