package com.eden.javalearning.annotation.inherited;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NotInheritedAnno {
}
