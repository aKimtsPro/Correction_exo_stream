package com.bstorm.correction.streams;

import com.bstorm.correction.streams.presentation.Menu;
import com.bstorm.correction.streams.service.Magasin;
import com.bstorm.correction.streams.service.MagasinFiller;

public class Main {

    public static void main(String[] args) {
        Magasin m = new Magasin("Bidule", 1000);
        MagasinFiller.fill(m);
        new Menu(m).start();
    }
}
