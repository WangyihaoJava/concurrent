package com.example.demo;

import org.openjdk.jol.info.ClassLayout;

import java.io.FileInputStream;
/**
 * @author wangyihao
 * @ClassName MyClassLoaderTest
 * @date 2021/6/18 14:28
 * @Description
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name
                    + ".class");
            int len = fis.available();
            byte[] data = new byte[len];

            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {

                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        /**
         * 32 * 重写类加载方法，实现自己的加载逻辑，不委派给双亲加载 33 * @param name 34 * @param resolve 35 * @return 36 * @throws ClassNotFoundException 37
         */
       /* @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    // If still not found, then invoke findClass in order 46 // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);
                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }*/
    }

    public static void main(String args[]) {
        /*MyClassLoader classLoader = new MyClassLoader("D:\\project\\concurrent\\demo\\src\\main\\java\\com\\example\\demo\\Test.java");
        //尝试用自己改写类加载机制去加载自己写的java.lang.String.class

        Class clazz = classLoader.loadClass("java.lang.String");
        Object obj = null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method method= null;
        try {
            method = clazz.getDeclaredMethod("sout", null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(obj, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(clazz.getClassLoader().getClass().getName());*/
        ClassLayout classLayout = ClassLayout.parseInstance(new Object());
        System.out.println(classLayout.toPrintable());
    }





}
