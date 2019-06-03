#!/usr/bin/env groovy
package com.jdcloud
import com.jdcloud.Address

@Grab('org.yaml:snakeyaml:1.17')
import org.yaml.snakeyaml.Yaml

class ParseYaml{

    def Cmds c
    ParseYaml(String path){

//        Yaml yaml = new Yaml()
//        File file = new File(path)
//        FileInputStream stream = new FileInputStream(file);
//        this.c = yaml.loadAs(stream, Cmds.class)
    }

    def SetUp(){
        String yamlStr = "key: hello yaml";
        Yaml yaml = new Yaml();
        Object ret = yaml.load(yamlStr);
        return ret
    }

    def SetUp2(){
        Yaml yaml = new Yaml()
        File file = new File("/root/build.yaml")
        FileInputStream stream = new FileInputStream(file);
        Address c = new yaml.loadAs(stream, Address.class)
        return c
    }
}