import interfaces.SomeInterface;
import interfaces.SomeOtherInterface;
public class SomeBean {
    @AutoInjectable
    private SomeInterface impl1;
    @AutoInjectable
    private SomeOtherInterface impl2;
    public void foo(){
        impl1.doSomething();
        impl2.doSomeOther();
    }
}
