package com.sparta.week5.login;

public enum UserRoleEnum {
    USER(Authority.USER), // 사용자 권한
    CEO(Authority.CEO); // 관리자 권한

    private static final String PREFIX_ROLE ="ROLE_";
    private final String authority;

    UserRoleEnum(String authority) {

        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String USER = "ROLE_USER";
        public static final String CEO = "ROLE_CEO";
    }
}