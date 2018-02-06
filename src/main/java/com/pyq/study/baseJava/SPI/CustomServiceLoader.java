package com.pyq.study.baseJava.SPI;

import org.apache.commons.io.IOUtils;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义实现服务发现serviceLoader
 * 1：根据Class类型获取接口相对路径
 * 2：根据接口契约拼接 服务装配配置文件 URL
 * 3：根据 URL 读取服务配置文件内容（实现接口的服务全路径名）
 * 4：根据实现服务的全路径名 ，通过反射实例化。（实现的服务必须保证有无参构造函数）
 * 5：通过反射的实例，动态化加载实现服务
 */
public class CustomServiceLoader {

    public static final String MAPPING_CONFIG_PREFIX = "META-INF/services";

    public static <S> List<S> loade(Class<S> service) throws Exception{
        String mappingConfigFile = MAPPING_CONFIG_PREFIX + "/" + service.getName() ;
        //由于一个接口的实现类可能存在多个jar包中的META-INF目录下，所以下面使用getResources返回一个URL数组
        Enumeration<URL> configFileUrls =  CustomServiceLoader.class.getClassLoader().getResources(mappingConfigFile);
        if(configFileUrls == null){
            return null ;
        }
        List<S> services = new LinkedList<S>();
        while(configFileUrls.hasMoreElements()){
            URL configFileUrl = configFileUrls.nextElement();
            String configContent = IOUtils.toString(configFileUrl.openStream());
            String[] serviceNames = configContent.split("\n");
            for(String serviceName : serviceNames){
                Class serviceClass = CustomServiceLoader.class.getClassLoader().loadClass(serviceName);
                Object serviceInstance = serviceClass.newInstance();
                services.add((S)serviceInstance);
            }
        }
        return services ;
    }

}
