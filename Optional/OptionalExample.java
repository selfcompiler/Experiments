package java8.OptionalExample;
// https://www.mkyong.com/java8/java-8-optional-in-depth/
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        Optional<String> text= Optional.of("BANGALORE");

        String nonnull="nonnull VALUE";

        String nullString=null;



        System.out.printf(" "+text);

        System.out.println(text.get());

        System.out.println(String.valueOf(text.hashCode()));

        System.out.println(" X= "+Optional.ofNullable(nonnull));

        System.out.println(" Y = "+Optional.ofNullable(nullString));

        System.out.println(" Z = "+Optional.of(nonnull).get());

        System.out.println(" Z = "+Optional.of(nullString));
    }


}

/*
 Optional[BANGALORE]BANGALORE
886496127
 X= Optional[nonnull VALUE]
 Y = Optional.empty
 Z = nonnull VALUE
Exception in thread "main" java.lang.NullPointerException
	at java.util.Objects.requireNonNull(Objects.java:203)
	at java.util.Optional.<init>(Optional.java:96)
	at java.util.Optional.of(Optional.java:108)
	at java8.OptionalExample.OptionalExample.main(OptionalExample.java:31)
  */
