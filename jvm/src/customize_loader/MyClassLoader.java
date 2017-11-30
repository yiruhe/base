package customize_loader;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{

    private String name;
    private String  path = "d:/";
    private final String fileType = ".class";

    public MyClassLoader(String name){

        super(); //让系统类加载器为该类的父加载器

        this.name = name;

    }


    public MyClassLoader(ClassLoader parent,String name){

        super(parent);

        this.name=name;

    }


    //必须重新findClass
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{

        byte[] data = this.loadClassDate(name);

        //通过definedClass转换为class实例
        return this.defineClass(name,data,0,data.length);

    }


    //获取class文件的二进制数据
    private byte[] loadClassDate(String name){

        InputStream is = null;
        byte[] data = null;

        ByteArrayOutputStream out = null;

        try{

            //把包名转换为路径
            this.name = this.name.replace(".","/");

            //读取类
            is = new FileInputStream(this.path);

            //输出到数组中
            out = new ByteArrayOutputStream();

            int ch = 0;

            while(-1 != (ch = is.read()))
            {

                out.write(ch);

            }

            data = out.toByteArray();

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{

            if(is != null)is.close();


            }catch(Exception e){



            }


        }

        return data;

    }


}
