package test.object;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanggan on 12/7/15.
 */
public class TestModel {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        TestModel model = new TestModel();
        model.sayHello();

        Integer age = 18;
        TestModel testModel = new TestModel();
        testModel.setName("zhangsan");
        testModel.setAge(age);

        TestModel newTestModel = new TestModel();
        newTestModel.setName(testModel.getName());
        newTestModel.setAge(testModel.getAge());

        age += 1;

        System.out.println(age);
        System.out.println(testModel.getAge());
        System.out.println(newTestModel.getAge());

        double f = 11.345;
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));

        System.out.println(String.format("%.2f", f));
    }
}
