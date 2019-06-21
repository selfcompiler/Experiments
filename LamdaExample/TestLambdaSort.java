package LambdaExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLambdaSort  {

    public static void main(String[] args) {

        List<Developer> developerList=getListOfDevelopers();
        System.out.println("Before Sort");
        for(Developer developer:developerList){
            System.out.println(developer.getName());
        }

        // Sort without Lamda
        Collections.sort(developerList, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        System.out.println("After Sort");

        for(Developer developer:developerList){
            System.out.println(developer.getName());
        }

        developerList=getListOfDevelopers();

        developerList.sort(new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        System.out.println("After Sort With Lamda");

        for(Developer developer:developerList){
            System.out.println(developer.getName());
        }
    }

    private static List<Developer> getListOfDevelopers(){
        List<Developer> list=new ArrayList<>();
        list.add(new Developer("selfcompiler",new BigDecimal(24234234),27));
        list.add(new Developer("fselfcompiler",new BigDecimal(3231231),24));
        list.add(new Developer("aselfcompiler",new BigDecimal(2423424),23));
        list.add(new Developer("bselfcompiler",new BigDecimal(242343334),71));
        list.add(new Developer("cselfcompiler",new BigDecimal(4545234),44));
        list.add(new Developer("dselfcompiler",new BigDecimal(24234),17));
        list.add(new Developer("eselfcompiler",new BigDecimal(55434234),37));
        return list;
    }
}
