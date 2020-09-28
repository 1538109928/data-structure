package designPatterns;

import sun.instrument.InstrumentationImpl;

/**
 * @author jiangjingyu6
 * @date 2020/9/28
 */
public class Singleton {

}

/**
 * 单例模式实现1
 * <P>
 *     懒加载：是
 *     是否线程安全：否
 *     性能：执行效率高
 * </P>
 */
class Singleton1 {
    private static Singleton1 singleton1;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            return new Singleton1();
        }
        return singleton1;
    }
}

/**
 * 单例模式实现2
 * <P>
 *     懒加载：否
 *     是否线程安全：是
 *     性能：执行效率高，但类加载时就初始化，浪费内存
 * </P>
 */
class Singleton2 {
    private final static Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}

/**
 * 单例模式实现3
 * <P>
 *     懒加载：是
 *     是否线程安全：是
 *     性能：执行效率极低
 * </P>
 */
class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        if (singleton3 == null) {
            return new Singleton3();
        }
        return singleton3;
    }
}

/**
 * 单例模式实现4-双重校验，推荐使用
 * <P>
 *     懒加载：是
 *     是否线程安全：是
 *     性能：执行效率高
 * </P>
 */
class Singleton4 {
    private static volatile Singleton4 singleton4;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}