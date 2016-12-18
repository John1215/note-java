package com.github.deer_apple.controller;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author lwq
 */
@Import({SampleController.class})
@ImportResource("classpath:applicationContext.xml")
public class AllController {

}
