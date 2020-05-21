// Posted from EduTools plugin
class Application {

    String name;

    void run(String[] args) {
        System.out.println(name);
        int i = 0;
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}