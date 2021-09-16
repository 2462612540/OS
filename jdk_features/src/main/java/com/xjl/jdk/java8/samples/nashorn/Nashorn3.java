package com.xjl.jdk.java8.samples.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Working with java types from javascript.
 *
 * @author xjl
 */
public class Nashorn3 {

    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("load('res/nashorn3.js')");
    }

}