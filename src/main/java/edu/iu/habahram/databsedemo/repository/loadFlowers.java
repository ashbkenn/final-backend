package edu.iu.habahram.databsedemo.repository;

import edu.iu.habahram.databsedemo.model.Color;
import edu.iu.habahram.databsedemo.model.Flower;
import edu.iu.habahram.databsedemo.model.Occasion;
import edu.iu.habahram.databsedemo.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class loadFlowers implements CommandLineRunner {
    @Autowired
    FlowersRepository flowersRepository;

    @Override
    public void run(String... args) throws Exception {
        flowersRepository.saveAll(Arrays.asList(
                new Flower("Sugar Rush", 54.0F, Type.MIXED, Occasion.MOTHERSDAY, Color.RED),
                new Flower("Lemonade", 54.0F, Type.MIXED, Occasion.THANKYOU , Color.YELLOW),
                new Flower("The Angels", 54.0F, Type.ROSES, Occasion.BIRTHDAY , Color.RED),
                new Flower("Unbreakable", 59.0F, Type.LILIES, Occasion.BIRTHDAY , Color.MIXED),
                new Flower("Sierra Sunset", 54.0F, Type.LILIES, Occasion.MOTHERSDAY , Color.RED),
                new Flower("Casablanca", 59.0F, Type.MIXED, Occasion.THANKYOU , Color.MIXED)
        ));
    }
}
