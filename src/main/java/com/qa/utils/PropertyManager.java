package com.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static Properties props = new Properties();
    TestUtils utils = new TestUtils();

    public Properties getProps() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties";

        if (props.isEmpty()){
            try {
                utils.log().info("Loading Config Properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            }catch (Exception e){
                e.printStackTrace();
                utils.log().fatal("Failed to load Config Properties.  ABORT!!!" + e.toString());
                throw e;
            }finally {
                if (is!= null){
                    is.close();
                }
            }
        }
        return props;
    }
}
