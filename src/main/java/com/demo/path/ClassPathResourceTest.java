package com.demo.path;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ClassPathResourceTest {
    public static void main(String[] args) throws IOException {
        ClassPathResource resource = new ClassPathResource(("generatorConfig.xml"));
        System.out.println(resource.getInputStream());
    }

}
