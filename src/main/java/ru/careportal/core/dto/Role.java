package ru.careportal.core.dto;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
            ADMIN, PATIENT, DOCTOR;


    @Override
    public String getAuthority() {
        return name();
    }
}
