package com.liang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @ClassName RootConfig
 * @Description TODO
 * @Author Liang Xi
 * @DATE 2020/11/27 19:42
 * @Version 1.0
 */
@Configuration
@ComponentScan(value = "com.liang",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})})
public class RootConfig {
}
