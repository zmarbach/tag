package org.improving.tag;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration///i am here to configure spring
@ComponentScan("org.improving.tag")//i want Spring to scan this package, find all classes that has "@Component" in it and memorize them
public class SpringContext {
}
