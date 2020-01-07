package java8.ForEach;

import java.util.HashMap;
import java.util.Map;

public class ForEachExample {

    public static void main(String[] args) {

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        items.forEach((k,v)-> System.out.printf("Key="+k+" Value="+v));

        items.forEach((k,v)->{

            System.out.printf("Key="+k+" Value="+v);
        });

    }
}


/*
OutPut :
Item : A Count : 10
Item : B Count : 20
Item : C Count : 30
Item : D Count : 40
Item : E Count : 50
Item : F Count : 60
Key=A Value=10Key=B Value=20Key=C Value=30Key=D Value=40Key=E Value=50Key=F Value=60Key=A Value=10Key=B Value=20Key=C Value=30Key=D Value=40Key=E Value=50Key=F Value=60
 */
