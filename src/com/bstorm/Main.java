package com.bstorm;

import com.bstorm.presentation.Menu;
import com.bstorm.service.Magasin;
import com.bstorm.service.MagasinFiller;

public class Main {

    public static void main(String[] args) {
        Magasin m = new Magasin("Bidule", 1000);
        MagasinFiller.fill(m);
        new Menu(m).start();
    }
}
