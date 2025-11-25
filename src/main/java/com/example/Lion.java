package com.example;

import java.util.List;

public class Lion implements Predator{

    boolean hasMane;
    Predator predator;
    FelineInterface felineInterface;

    public Lion(String sex, Predator predator, FelineInterface felineInterface) throws Exception {
        this.predator = predator;
        this.felineInterface = felineInterface;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return felineInterface.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    @Override
    public List<String> eatMeat() throws Exception {
        return predator.eatMeat();
    }
    public List<String> getFood() throws Exception {
        return eatMeat();
    }

}
