package com.eden.javalearning.annotation.retentionpolicy.source;

import com.google.auto.service.AutoService;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Names;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;


@SupportedAnnotationTypes({"com.eden.javalearning.annotation.retentionpolicy.source.FlexBo"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class FlexBoProcessor extends AbstractProcessor {

    // 打印log
    private Messager messager;
    // 抽象语法树
    private JavacTrees trees;
    // 封装了创建AST节点的一些方法
    private TreeMaker treeMaker;
    // 提供了创建标识符的一些方法
    private Names names;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        this.trees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);

    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement typeElement : annotations) {

            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element element : annotatedElements) {
                JCTree jcTree = trees.getTree(element);
                jcTree.accept(new TreeTranslator() {
                    @Override
                    public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {

                        super.visitClassDef(jcClassDecl);
                    }

                    @Override
                    public void visitVarDef(JCTree.JCVariableDecl jcVariableDecl) {
                        System.out.println(jcVariableDecl.vartype);
                        System.out.println(jcVariableDecl.init);
                        super.visitVarDef(jcVariableDecl);
                    }

                    @Override
                    public void visitMethodDef(JCTree.JCMethodDecl jcMethodDecl) {
                        System.out.println(jcMethodDecl.body);
                        super.visitMethodDef(jcMethodDecl);
                    }


                });
            }


        }


        return true;
    }


    private JCTree.JCVariableDecl makeFlexVariable() {
        // treeMaker.VarDef(treeMaker.Modifiers(Flags.PRIVATE), names.fromString("jsonobj"), memberAccess("java.util.Map<String, Ojbect>"), )
        return null;
    }


    private JCTree.JCExpression memberAccess(String components) {
        String[] componentArray = components.split("\\.");
        JCTree.JCExpression expr = treeMaker.Ident(names.fromString(componentArray[0]));
        for (int i = 1; i < componentArray.length; i++) {
            expr = treeMaker.Select(expr, names.fromString(componentArray[i]));
        }
        return expr;

    }

}
