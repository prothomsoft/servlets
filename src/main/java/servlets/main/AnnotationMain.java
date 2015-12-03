package servlets.main;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
   String name() default "";
   String surName() default "";
}

class Annotated {
   @Author(name = "Tomasz", surName = "Prokop")
   public void foo(String myParam1, String myParam2) {
      System.out.println("Author is " + myParam1 + " " + myParam2);
   }
}

public class AnnotationMain {
   public static void main(String[] args) throws Exception {
      TestAnnotationParser parser = new TestAnnotationParser();
      parser.parse(Annotated.class);
   }
}

class TestAnnotationParser {
    public void parse(Class clazz) throws Exception {
       Method[] methods = clazz.getMethods();
       for (Method method : methods) {
          if (method.isAnnotationPresent(Author.class)) {
             Author author = method.getAnnotation(Author.class);
             String name = author.name();
             String surName = author.surName();
             method.invoke(Annotated.class.newInstance(),name, surName);
          }
       }
    }
 }