package com.flab.LiveCommerce.common.auth.annotation;


import com.flab.common.auth.Role;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginCheck {

    Role authority() default Role.UNAUTH;
}
