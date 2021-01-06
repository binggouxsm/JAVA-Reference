package com.eden.javalearning.annotation.retentionpolicy.source;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;

public class JavaParse {
    public static void main(String[] args) throws Exception{
        CompilationUnit cu = StaticJavaParser.parse(new File("d://FlexBoTest.java"));
        System.out.println(cu);
    }
}
