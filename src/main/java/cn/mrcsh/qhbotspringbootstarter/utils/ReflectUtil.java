package cn.mrcsh.qhbotspringbootstarter.utils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class ReflectUtil {
    private ReflectUtil() {
    }

    /**
     * 遍历所有的字段（属性）
     *
     * @param Type     类型.class
     * @param consumer 外部接口
     */
    public static void forEachFields(Class<?> Type, Consumer<Field> consumer) {
        forEachSuper(Type, SuperType -> {
            Field[] fields = SuperType.getDeclaredFields();
            for (Field field : fields) {
                consumer.accept(field);
            }
        });

    }

    /**
     * 遍历所有的方法
     *
     * @param Type     类型.class
     * @param consumer 外部接口
     */
    public static void forEachMethods(Class<?> Type, Consumer<Method> consumer) {
        forEachSuper(Type, SuperType -> {
            Method[] methods = SuperType.getDeclaredMethods();
            for (Method method : methods) {
                consumer.accept(method);
            }
        });
    }

    /**
     * 遍历父类
     *
     * @param Type     类型.class
     * @param consumer 外部接口
     */
    public static void forEachSuper(Class<?> Type, Consumer<Class<?>> consumer) {
        Objects.requireNonNull(Type);
        Class<?> SuperType = Type;
        while (SuperType != null && !SuperType.equals(Object.class)) {
            consumer.accept(SuperType);
            SuperType = SuperType.getSuperclass();
        }
    }

    /**
     * 获取字段
     *
     * @param instance  实例
     * @param FieldName 字段名
     * @param <T>       任何类型对象
     * @return 字段对象
     */
    public static <T> Field getField(T instance, String FieldName) {
        AtomicReference<Field> field = new AtomicReference<>();
        Class<?> type = instance.getClass();
        forEachFields(type, field1 -> {
            if (field1.getName().equals(FieldName)) {
                field.set(field1);
            }
        });
        return field.get();
    }

    /**
     * 执行方法
     *
     * @param instance   对象
     * @param MethodName 方法名
     * @param args       参数
     * @param <T>        任何对象
     */
    public static <T> Object invokeMethod(T instance, String MethodName, Object... args) {
        AtomicReference<Method> resmethod = new AtomicReference<>();
        forEachMethods(instance.getClass(), method -> {
            if (method.getName().equals(MethodName)) {
                method.setAccessible(true);
                resmethod.set(method);
            }
        });
        try {
            return resmethod.get().invoke(instance, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置字段值
     *
     * @param instance  对象
     * @param FieldName 字段名
     * @param value     值
     * @param <T>       任何对象
     */
    public static <T> void setFieldValue(T instance, String FieldName, Object value) {
        forEachFields(instance.getClass(), field -> {
            if (field.getName().equals(FieldName)) {
                field.setAccessible(true);
                try {
                    field.set(instance, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /**
     * 获取字段的值
     *
     * @param instance  对象
     * @param FieldName 字段名
     * @param <T>
     * @return 值
     */
    public static <T> Object getFieldValue(T instance, String FieldName) {
        Field field = getField(instance, FieldName);
        field.setAccessible(true);
        try {
            return field.get(instance);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建对象
     *
     * @param clazz 类
     * @param <T>
     * @return 对象
     */
    public static <T> T createInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 重载创建对象方法
     *
     * @param clazz 类
     * @param args  参数
     * @param <T>
     * @return 对象
     */
    public static <T> T createInstance(Class<T> clazz, Object... args) {
        try {
            T instance = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                fields[i].set(instance, args[i]);
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 遍历所有Fields
     * @param clazz
     * @return
     */
    public static List<Field> getAllFields(Class<?> clazz){
        List<Field> fields = new ArrayList<>();
        forEachFields(clazz, (field)->{
            field.setAccessible(true);
            fields.add(field);
        });
        return fields;
    }

    /**
     * 拷贝属性值
     * @param from
     * @param to
     * @throws IllegalAccessException
     */
    public static void copyProperties(Object from, Object to) throws IllegalAccessException {
        Class<?> formClazz = from.getClass();
        Class<?> toClazz = to.getClass();
        for (Field allField : getAllFields(formClazz)) {
            for (Field field : getAllFields(toClazz)) {
                if(allField.getName().equals(field.getName())){
                    field.set(to,getFieldValue(from, allField.getName()));
                }
            }
        }
    }
}
