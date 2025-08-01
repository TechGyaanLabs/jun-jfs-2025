package com.careerit.jfs.cj.day30;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class WorkingWithYaml {

    public static void main(String[] args) {
        String data = """
               app:
                 name: Spring Boot
                 version: 2.7.0
               """;
        LoaderOptions loaderOptions = new LoaderOptions();
        Yaml yaml = new Yaml(new Constructor(AppWrapper.class,loaderOptions));
        AppWrapper appWrapper = yaml.load(data);
        System.out.println(appWrapper.getApp().getName());
        System.out.println(appWrapper.getApp().getVersion());

        String ymalString = yaml.dump(appWrapper);
        System.out.println(ymalString);
    }
}
