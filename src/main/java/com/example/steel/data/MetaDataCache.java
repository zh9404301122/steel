package com.example.steel.data;



import com.example.steel.exception.BaseException;
import com.example.steel.util.LocalFileReader;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class MetaDataCache {

    private MetaDataCache(){
        throw new BaseException("this is an util class, you should not create an object!");

    }

    private static final String PROP = "data/properties/";


    public static final Properties URL_PROPERTIES = new Properties();


    public static void boot(String env){
        initDbMapDruid(env);
    }

    private static void initDbMapDruid(String env) {
        String pathRelativeClassPath = "application-"+env+".properties";
        Properties envProperties = new Properties();
        LocalFileReader.getPropertiesByJdk(pathRelativeClassPath,envProperties);
        log.info("DB_MAP_DRUID init");
    }
}
