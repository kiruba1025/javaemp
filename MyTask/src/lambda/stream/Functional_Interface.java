package lambda.stream;
@FunctionalInterface
public interface Functional_Interface {
     public abstract void test();
     default void test1() {
    	 System.out.println("Hiiiiiiii");
     }
static void test2() {
	System.out.println("hellooooo");
}
}
