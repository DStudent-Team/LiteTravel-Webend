//通过代码进行配置Mybatis，本项目中未使用
package com.LiteTravel.web.config;


import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

//配置MyBatis的变量与属性的匹配
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }

    ;
}
