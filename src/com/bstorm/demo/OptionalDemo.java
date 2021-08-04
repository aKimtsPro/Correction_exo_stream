package com.bstorm.demo;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {


        //Creer
        Optional<String> opt = Optional.ofNullable(null);

        opt.get();
        String monString = opt.orElse("salut");
        monString = opt.orElseGet(() -> new String("salut"));
        opt = opt.or(() -> Optional.ofNullable(null));
        opt.orElseThrow(IllegalArgumentException::new);

    }

}
