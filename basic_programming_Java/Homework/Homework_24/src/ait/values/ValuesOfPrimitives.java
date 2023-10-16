package ait.values;

public class ValuesOfPrimitives {
    public static void main(String[] args) {
        if (args.length > 7) {
            System.out.println("Wrong number of arguments");
        } else {
            if (args.length == 0) {
                printAllPrimitives();
            }

            for(int i = 0; i < args.length; ++i) {
                System.out.println(valueOfPrimitives(args[i]));
            }

        }
    }

    private static void printAllPrimitives() {
        System.out.println("Byte max value= 127, min value= -128");
        System.out.println("Short max value= 32767, min value= -32768");
        System.out.println("Character max value= \uffff, min value= \u0000");
        System.out.println("Integer max value= 2147483647, min value= -2147483648");
        System.out.println("Float max value= 3.4028235E38, min value= 1.4E-45");
        System.out.println("Long max value= 9223372036854775807, min value= -9223372036854775808");
        System.out.println("Double max value= 1.7976931348623157E308, min value= 4.9E-324");
    }

    private static String valueOfPrimitives(String primitive) {
        switch (primitive) {
            case "byte":
                return "Byte max value= 127, min value= -128";
            case "short":
                return "Short max value= 32767, min value= -32768";
            case "char":
                return "Character max value= \uffff, min value= \u0000";
            case "int":
                return "Integer max value= 2147483647, min value= -2147483648";
            case "float":
                return "Float max value= 3.4028235E38, min value= 1.4E-45";
            case "long":
                return "Long max value= 9223372036854775807, min value= -9223372036854775808";
            case "double":
                return "Double max value= 1.7976931348623157E308, min value= 4.9E-324";
            default:
                return "Wrong type";
        }
    }
}
