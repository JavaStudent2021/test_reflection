package lib;

import controller.ConsoleHandler;
import dao.BetDAO;
import dao.impl.BetDaoFactory;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Injector {
    public static Object getInstance(Class clazz) throws Exception {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class)!=null){
                field.setAccessible(true);
                String nameField = field.getName();
                Class aClass = reflectionsScan(nameField);
                field.set(instance, BetDaoFactory.getObject(aClass));
            };


        }

        return instance;
    }

    private static Class reflectionsScan(String type) {
        Reflections reflections = new Reflections(Main.class.getPackage().getName());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Dao.class);

        for(Class cls: classes) {
            String string1 = type.toLowerCase();
            String string2 = cls.getSimpleName().toLowerCase();
            if (string2.startsWith(string1))
                return cls;
        }
        return null;
    }

    public static void injectDependency() throws ClassNotFoundException, NoSuchMethodException {
        Class<ConsoleHandler> consoleHandlerClass = (Class<ConsoleHandler>) Class.forName("com.trackenshure.controller.ConsoleHandler");

        Constructor constructor = consoleHandlerClass.getConstructor();
    }

}
