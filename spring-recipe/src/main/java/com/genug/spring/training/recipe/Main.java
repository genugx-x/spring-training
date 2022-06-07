package com.genug.spring.training.recipe;

import com.genug.spring.training.recipe.shop.Product;
import com.genug.spring.training.recipe.shop.config.ShopConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                // new AnnotationConfigApplicationContext("com.genug.spring.training.recipe.sequence");
                new AnnotationConfigApplicationContext(ShopConfiguration.class);


        // SequenceDao sequenceDao = context.getBean(SequenceDao.class);
        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);

        System.out.println(aaa);
        System.out.println(cdrw);
    }
}
