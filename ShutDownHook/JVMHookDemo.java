package ThreadExamples;

public class JVMHookDemo {

    public static void main(String[] args) throws InterruptedException {

        Runtime.getRuntime().addShutdownHook(new Thread(){

            public void run(){

                System.out.println("Shut Down Hook is Running");

            }
        });

        System.out.println("Press Ctrl + C to Run Hook ");

        Thread.sleep(60000);

        System.out.println("Application Termination");
    }


}
