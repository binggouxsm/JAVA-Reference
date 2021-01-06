package com.eden.javalearning.annotation.inherited;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface InheritedMethodAnno {
}
