package ait.reflection;

import ait.reflection.infra.FooService;
import ait.reflection.model.Foo;

public class FooAppl {
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("Wrong numbers of args");
            return;
        }
        Foo foo = new Foo();
        FooService fooService = new FooService(foo);
        fooService.caller(args[0], args[1]);
    }
}
