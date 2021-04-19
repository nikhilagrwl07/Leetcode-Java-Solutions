package java8;

@java.lang.FunctionalInterface
public interface FunctionalInterface {

    // one abstract method
    public void nonAbstractMethod();

    // any number of default non abstract method
    default void defaultMethod1(){
        System.out.println("First non default method");
    }

    default void defaultMethod2(){
        System.out.println("Second non default method");
    }

    // Can override java.lang.object
    @Override
    public int hashCode();
}
