package com.eurodyn.qlack2.fuse.search;

import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.replaceConfigurationFile;

import org.ops4j.pax.exam.ConfigurationManager;
import org.ops4j.pax.exam.Option;

import java.io.File;

/**
 * @author European Dynamics SA
 */
public class TestUtil {

   public static String karafVersion() {
        ConfigurationManager cm = new ConfigurationManager();
        return cm.getProperty("pax.exam.karaf.version");
    }

    public static String projectVersion() {
        ConfigurationManager cm = new ConfigurationManager();
        return cm.getProperty("project.version");
    }

    public static Option copyITConf(String path) {
        return replaceConfigurationFile(path, new File("src/test/conf/it/" + path));
    }
}