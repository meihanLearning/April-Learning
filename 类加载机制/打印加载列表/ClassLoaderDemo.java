public class ClassLoaderDemo {
    public static void printClassLoaderHierarchy() {
        // 获取当前类的类加载器
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        
        System.out.println("类加载器层次结构：");
        while (classLoader != null) {
            System.out.println(classLoader.toString());
            classLoader = classLoader.getParent();
        }
        // 打印根类加载器（Bootstrap ClassLoader）
        System.out.println("Bootstrap ClassLoader");
    }

    public static void printLoadedClasses() {
        // 获取当前线程的上下文类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("\n当前线程上下文类加载器：" + contextClassLoader);
        
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemClassLoader);
        
        // 获取扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("扩展类加载器：" + extClassLoader);
    }

    public static void printBootstrapClasses() {
        System.out.println("\n=== Bootstrap ClassLoader 加载的核心类示例 ===");
        
        // 获取一些核心类的类加载器
        ClassLoader stringLoader = String.class.getClassLoader();
        ClassLoader systemLoader = System.class.getClassLoader();
        ClassLoader objectLoader = Object.class.getClassLoader();
        
        System.out.println("String类的类加载器: " + stringLoader);
        System.out.println("System类的类加载器: " + systemLoader);
        System.out.println("Object类的类加载器: " + objectLoader);
        
        // 打印一些核心类的完整类名
        System.out.println("\n一些核心类的完整类名：");
        System.out.println("java.lang.String: " + String.class.getName());
        System.out.println("java.lang.System: " + System.class.getName());
        System.out.println("java.lang.Object: " + Object.class.getName());
        System.out.println("java.lang.Thread: " + Thread.class.getName());
        System.out.println("java.lang.ClassLoader: " + ClassLoader.class.getName());
    }

    public static void printBootstrapClassDetails() {
        System.out.println("\n=== Bootstrap ClassLoader 加载的类的详细信息 ===");
        
        // 获取一些核心类的类加载器
        ClassLoader stringLoader = String.class.getClassLoader();
        ClassLoader systemLoader = System.class.getClassLoader();
        ClassLoader objectLoader = Object.class.getClassLoader();
        
        System.out.println("String类的类加载器: " + stringLoader);
        System.out.println("System类的类加载器: " + systemLoader);
        System.out.println("Object类的类加载器: " + objectLoader);
        
        // 打印一些核心类的详细信息
        System.out.println("\n核心类的详细信息：");
        System.out.println("String类的位置: " + String.class.getProtectionDomain().getCodeSource());
        System.out.println("System类的位置: " + System.class.getProtectionDomain().getCodeSource());
        System.out.println("Object类的位置: " + Object.class.getProtectionDomain().getCodeSource());
        
        // 打印一些核心类的包信息
        System.out.println("\n核心类的包信息：");
        System.out.println("String类的包: " + String.class.getPackage());
        System.out.println("System类的包: " + System.class.getPackage());
        System.out.println("Object类的包: " + Object.class.getPackage());
    }
} 