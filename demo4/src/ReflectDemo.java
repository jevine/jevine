import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        /*getMyClass();
        getMyFiled();
        getMethodDemo();*/
        //getMethodDemo2();
        getMethodDemo3();

    }

    public static void getMethodDemo3() throws Exception{
        Class cla=Class.forName("Person");
        Method method=cla.getMethod("setName", String.class);
        Object obj=cla.newInstance();
        method.invoke(obj,"jj");
    }

    public static void getMethodDemo2() throws Exception {
        Class cla=Class.forName("Person");
        Method method=cla.getMethod("show",null);
        //Object obj=cla.newInstance();
        Constructor constructor=cla.getConstructor(String.class,int.class);
        Object obj=constructor.newInstance("hh",55);
        method.invoke(obj,null);
    }

    public static void getMethodDemo() throws ClassNotFoundException {
        Class clazz=Class.forName("Person");
        Method[] methods=clazz.getMethods();
        methods=clazz.getDeclaredMethods();
        for (Method me:methods) {
            System.out.println(me);
            
        }
        
    }

    public static void getMyFiled() throws Exception{
        String name="Person";
        Class clazz=Class.forName(name);
        Field field=clazz.getDeclaredField("age");
        field.setAccessible(true);
        Object object=clazz.newInstance();
        field.set(object,99);
        Object o=field.get(object);

        System.out.println(o);
    }

    public static void getMyClass() throws Exception{
        String name="Person";
        Class clazz=Class.forName(name);
        Constructor constructor=clazz.getConstructor(String.class,int.class);
        Object obj=constructor.newInstance("shuaijian",21);
    }
}
