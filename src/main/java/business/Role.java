package business;

public enum Role {
    ADMIN("ADMIN"),
    EMPLOYEE("EMPLOYEE"),
    CLIENT("CLIENT");

    private final String roleType;

    Role(String roleType){
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }

    public static business.Role setRole(String roleType){
        switch(roleType){
            case "ADMIN":
                return business.Role.ADMIN;
            case "EMPLOYEE":
                return business.Role.EMPLOYEE;
            case "CLIENT":
                return business.Role.CLIENT;
            default:
                return null;
        }
    }
}
