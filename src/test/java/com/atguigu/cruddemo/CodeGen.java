package com.atguigu.cruddemo;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * project:CrudDemo
 * package:com.atguigu.crudDemo
 * class:s
 *
 * @author: smile
 * @create: 2023/6/30-18:05
 * @Version: v1.0
 * @Description:
 */
public class  CodeGen {
    public static void main(String[] args) {

//        String  moduleName = "CrudDemo";
//        //String projectPath = "D:/project/yygh/guigu-syt-parent";
//        String projectPath = System.getProperty("user.dir");

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\Java\\尚硅谷java20230201\\20230201javaSEcode\\CrudDemo" + "/src/main/java");
//        System.out.println(projectPath);

        //%s表示占位符，实现字符串拼接。这里%s是首字符大写的实体名称。
        //默认情况下：service接口名称的生成规则是 I%sService，这里我们将它改成习惯用的%sService
        gc.setServiceName("%sService");
        //默认情况下：controller接口名称的生成规则是 %sController，这里我们添加一个Admin前缀
        gc.setControllerName("Admin%sController");
        gc.setAuthor("atguigu");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/aa_crude?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("190325");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("CrudDemo"); //模块名
        pc.setParent("com.atguigu.cruddemo");
        pc.setController("controller.admin");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setRestControllerStyle(true); //restful api风格控制器
        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }

}

