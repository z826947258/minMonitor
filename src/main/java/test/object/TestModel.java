package test.object;

/**
 * Created by zhanggan on 12/7/15.
 */
public class TestModel {
    public void sayHello() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        TestModel model = new TestModel();
        model.sayHello();
    }
}
