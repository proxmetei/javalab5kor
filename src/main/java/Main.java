public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Injector injector = new Injector();
        SomeBean bean = new SomeBean();
        injector.inject(bean);
        bean.foo();
    }
}
