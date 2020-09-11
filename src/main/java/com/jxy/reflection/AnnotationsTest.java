package com.jxy.reflection;

import java.lang.annotation.Annotation;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AnnotationsTest {
    public static void main(String[] args) {
        Class<ReflectableClass> object = ReflectableClass.class;
        // Retrieve all annotations from the class
        Annotation[] annotations = object.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }


        // Checks if an annotation is present
        if (object.isAnnotationPresent(Reflectable.class)) {
            // Gets the desired annotation
            Annotation annotation = object.getAnnotation(Reflectable.class);

            System.out.println(annotation + " present in class " + object.getClass());// java.lang.class
            System.out.println(annotation + " present in class " + object.getTypeName());// 	com.danibuiza.javacodegeeks.reflection.ReflectableClass

        }

    }

    @Deprecated
    class ReflectableClass extends Reflectable {
    }


}
