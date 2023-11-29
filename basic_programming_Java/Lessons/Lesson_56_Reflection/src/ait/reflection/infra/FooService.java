package ait.reflection.infra;

import ait.reflection.model.Foo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FooService {
    private Foo foo;

    public FooService(Foo foo) {
        this.foo = foo;
    }

    public void caller(String funcName, String arg){
        try {
            Class<?> clazz = Class.forName("ait.reflection.model.Foo");
            Method method = clazz.getDeclaredMethod(funcName, String.class);
            method.setAccessible(true);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            method.invoke(constructor.newInstance(), arg);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(funcName + " doesn't exist");
        }
    }

//    public void caller(String funcName, String arg){
//        switch (funcName){
//            case "f1":
//                foo.f1(arg);
//                break;
//            case "f2":
//                foo.f2(arg);
//                break;
//            case "f3":
//                foo.f3(arg);
//                break;
//            default:
//                System.out.println(funcName + " doesn't exist");
//        }
//    }
}
