import model.Resume;
import storage.ArrayStorage;
import storage.Storage;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        field.setAccessible(true);
        field.get(r);
        System.out.println(r);
        field.set(r, "new uuid");
        System.out.println(r);

        // TODO : invoke r.toString via reflection 13:00
        Method method = r.getClass().getDeclaredMethod("toString");
        System.out.println(method.invoke(r));

        Storage storage = new ArrayStorage();
        storage.save(new Resume("uuid1"));
        storage.save(new Resume("uuid2"));
        storage.save(new Resume("uuid3"));
        System.out.println(storage.size());
    }
}
