## skinny-logback

A useful logback library.

### build.sbt

```scala
libraryDependencies += "org.skinny-framework" % "skinny-logback" % "1.0.8"
```

### build.gradle

```
compile 'org.skinny-framework:skinny-logback:1.0.8'
```

### pom.xml

```xml
<dependency>
    <groupId>org.skinny-framework</groupId>
    <artifactId>skinny-logback</artifactId>
    <version>1.0.8</version>
</dependency>
```

### src/main/resources/logback.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <property name="CONSOLE_LOG_PATTERN" value="%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(%5p) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t{14}]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n%wex"/>
    <conversionRule conversionWord="clr" converterClass="skinny.logging.logback.ColorConverter" />
    <conversionRule conversionWord="wex" converterClass="skinny.logging.logback.WhitespaceThrowableProxyConverter" />
    <appender name="default" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${CONSOLE_LOG_PATTERN}</pattern>
            <charset>utf-8</charset>
        </encoder>
    </appender>
    <root level="info">
        <appender-ref ref="default"/>
    </root>
</configuration>
```
