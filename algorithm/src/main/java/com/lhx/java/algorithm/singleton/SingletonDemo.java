package com.lhx.java.algorithm.singleton;

/**
 * Created by lihongxin on 2019/2/8
 */
public class SingletonDemo {
    //懒汉式 线程不安全
    public static class LazySingletonNotSafe {
        private static LazySingletonNotSafe lazySingletonNotSafeInstance;

        private LazySingletonNotSafe() {

        }

        public static LazySingletonNotSafe getLazySingletonNotSafeInstance() {
            if (lazySingletonNotSafeInstance == null) {
                lazySingletonNotSafeInstance = new LazySingletonNotSafe();
            }
            return lazySingletonNotSafeInstance;
        }
    }

    //懒汉式 线程安全
    public static class LazySingletonSafe {
        private static LazySingletonSafe lazySingletonSafeInstance;

        private LazySingletonSafe() {
        }

        public static synchronized LazySingletonSafe getHungrySingletonSafeInstance() {
            if (lazySingletonSafeInstance == null) {
                lazySingletonSafeInstance = new LazySingletonSafe();
            }
            return lazySingletonSafeInstance;
        }
    }

    //饿汉式
    public static class HungrySingleton {
        private static HungrySingleton hungrySingletonInstance = new HungrySingleton();

        private HungrySingleton() {
        }

        public static HungrySingleton getHungrySingletonInstance() {
            return hungrySingletonInstance;
        }
    }

    //双重锁校验
    public static class DoubleLockSingleton {
        private static volatile DoubleLockSingleton doubleLockSingletonInstance = null;

        private DoubleLockSingleton() {
        }

        public static DoubleLockSingleton getDoubleLockSingletonInstance() {
            if (doubleLockSingletonInstance == null) {
                //第一次判断是否为null 判断是否有必要加锁
                synchronized (DoubleLockSingleton.class) {
                    if (doubleLockSingletonInstance == null) {
                        //第二次判断为null 加锁过程是否有被实例化。
                        doubleLockSingletonInstance = new DoubleLockSingleton();
                    }
                }
            }
            return doubleLockSingletonInstance;
        }
    }

    //静态内部类方式
    public static class StaticClassSingleton {
        private final static class SingletonHelper {
            private static final StaticClassSingleton staticClassSingleton = new StaticClassSingleton();
        }

        private StaticClassSingleton() {
        }

        public static StaticClassSingleton getStaticClassSingletonInstence() {
            return SingletonHelper.staticClassSingleton;
        }
    }

    //枚举式
    public enum EnumSingleton {
        INSTANCE;

        public void whateverMethod() {
        }
    }

    public static void main(String[] args) {
        LazySingletonNotSafe lazySingletonNotSafe = LazySingletonNotSafe.getLazySingletonNotSafeInstance();
        LazySingletonSafe lazySingletonSafe = LazySingletonSafe.getHungrySingletonSafeInstance();
        HungrySingleton hungrySingleton = HungrySingleton.getHungrySingletonInstance();
        DoubleLockSingleton doubleLockSingleton = DoubleLockSingleton.getDoubleLockSingletonInstance();
        StaticClassSingleton staticClassSingleton = StaticClassSingleton.getStaticClassSingletonInstence();
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;

    }
}
