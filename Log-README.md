https://www.slf4j.org/manual.html

https://reload4j.qos.ch/

https://logging.apache.org/log4j/2.x/index.html

https://logging.apache.org/log4j/2.x/log4j-slf4j-impl/index.html

The Log4j 2 SLF4J Binding allows applications coded to the SLF4J API to use Log4j 2 as the implementation.

Due to a break in compatibility in the SLF4J binding, as of release 2.19.0 two SLF4J to Log4j Adapters are provided.

log4j-slf4j-impl should be used with SLF4J 1.7.x releases or older.
log4j-slf4j2-impl should be used with SLF4J 2.0.x releases or newer.
Applications that take advantage of the Java Module System should use SLF4J 2.0.x and log4j-slf4j2-impl.

As of release 2.19.0 the log4j-slf4j18-impl module targetting the unreleased SLF4J 1.8.x series has been removed.



Configuration of Log4j 2 can be accomplished in 1 of 4 ways:

Through a configuration file written in XML, JSON, YAML, or properties format.
Programmatically, by creating a ConfigurationFactory and Configuration implementation.
Programmatically, by calling the APIs exposed in the Configuration interface to add components to the default configuration.
Programmatically, by calling methods on the internal Logger class.


Log4j has the ability to automatically configure itself during initialization. When Log4j starts it will locate all the ConfigurationFactory plugins and arrange them in weighted order from highest to lowest. As delivered, Log4j contains four ConfigurationFactory implementations: one for JSON, one for YAML, one for properties, and one for XML.

Log4j will inspect the "log4j2.configurationFile" system property and, if set, will attempt to load the configuration using the ConfigurationFactory that matches the file extension. Note that this is not restricted to a location on the local file system and may contain a URL.
If no system property is set the properties ConfigurationFactory will look for log4j2-test.properties in the classpath.
If no such file is found the YAML ConfigurationFactory will look for log4j2-test.yaml or log4j2-test.yml in the classpath.
If no such file is found the JSON ConfigurationFactory will look for log4j2-test.json or log4j2-test.jsn in the classpath.
If no such file is found the XML ConfigurationFactory will look for log4j2-test.xml in the classpath.
If a test file cannot be located the properties ConfigurationFactory will look for log4j2.properties on the classpath.
If a properties file cannot be located the YAML ConfigurationFactory will look for log4j2.yaml or log4j2.yml on the classpath.
If a YAML file cannot be located the JSON ConfigurationFactory will look for log4j2.json or log4j2.jsn on the classpath.
If a JSON file cannot be located the XML ConfigurationFactory will try to locate log4j2.xml on the classpath.
If no configuration file could be located the DefaultConfiguration will be used. This will cause logging output to go to the console.


启动脚本应该使用log4j2.configurationFile指定log4j配置文件的位置