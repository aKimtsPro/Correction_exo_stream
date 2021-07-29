package com.bstorm.correction;

import com.bstorm.correction.presentation.Menu;
import com.bstorm.correction.service.Magasin;
import com.bstorm.correction.service.MagasinFiller;

public class Main {

    public static void main(String[] args) {
        Magasin m = new Magasin("Bidule", 1000);
        MagasinFiller.fill(m);
        new Menu(m).start();
    }
}
