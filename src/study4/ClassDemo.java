package study4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * 反射
 * <p>
 * 1. getClass() 方法，获取对象的字节代码文件类 Class；
 * 2. getConstructor() 方法，获取类构造函数的代码类，然后进行操作；
 * 3. getParameterTypes() 方法获取参数类型；
 */
public class ClassDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person = new Person();

        Class<? extends Person> personClass = person.getClass();

        Constructor<? extends Person> constructor = personClass.getConstructor(String.class, int.class);
        int modifiers = constructor.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.isPublic(modifiers));
        System.out.println(Modifier.toString(modifiers));

        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            System.out.println(parameterTypes[i]);
        }

        Person tom;
        tom = (Person) constructor.newInstance("tom", 20);
        tom.talk("Hello");


        // 获取属性变量
        Field[] fields = personClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println("属性变量代码" + i + " : " + field.getName());
            System.out.println("属性变量类型" + i + " : " + field.getType());

            // 获取 tom 对象的字段值
            System.out.println(field.get(tom));

            if (field.getType().equals(int.class)){
                field.setInt(tom, 30);
            }
            System.out.println("tom 的年龄改为了： " + field.get(tom));


        }
    }
}
