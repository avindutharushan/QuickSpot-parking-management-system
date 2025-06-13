package lk.ijse.userservice.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    DRIVER("DRIVER"),
    OWNER("OWNER"),
    ADMIN("ADMIN");

    private final String roleByString;

    public static UserRole fromString(String roleString) {
        for (UserRole role : UserRole.values()) {
            if (role.getRoleByString().equalsIgnoreCase(roleString)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + roleString);
    }
}
