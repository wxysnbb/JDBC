package cn.wd.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    //1.创建私有静态类变量
    private static ConfigManager configManager;
    //创建Properties对象 专门解析properties文件
    private static Properties properties;

    //2.创建静态代码块
    static{
        String path="jdbc.properties";
        properties=new Properties();//实例化对象
        //使用反射机制来动态加载properties文件中的内容
        InputStream stream = ConfigManager.class.getClassLoader().getResourceAsStream(path);
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭流
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //3.创建共有静态方法充当对外访问的接口
    public static ConfigManager getInstens(){
        return configManager;
    }
    //properties已经有值了properties已经进入内存，我们就可以通过key获取到value
    public static String getValue(String key){
        return properties.getProperty(key);
    }

}
