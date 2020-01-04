package differentwaystoread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {

    public static void main(String[] args) {

        BufferedReader bufferedReader=null;

        try {

            bufferedReader=new BufferedReader(new InputStreamReader(System.in));

            while (true){

                System.out.printf("Enter Something");

                String input= bufferedReader.readLine();

                if("q".equals(input)){

                    System.out.printf("Exit");
                    System.exit(0);

                }
                System.out.printf("Input : "+input);
                System.out.printf("-------------\n");
            }

        }catch (IOException ex){

            ex.printStackTrace();

        }
        finally {
            if(bufferedReader!=null){

                try {
                    bufferedReader.close();
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}


