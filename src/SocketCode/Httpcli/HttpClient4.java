package SocketCode.Httpcli;

/**
 * Created by yuan4j on 2017/3/20.
 */
import java.net.*;
import java.io.*;
public class HttpClient4{
    public static void main(String args[])throws IOException{
        URL url=new URL("http://tieba.baidu.com/index.html");
        URLConnection connection=url.openConnection();
        //接收响应结果
        InputStream in=connection.getInputStream(); //读取响应正文
        Class[] types={String.class,InputStream.class};
        Object obj=connection.getContent(types);
        if(obj instanceof String){
            System.out.println(obj);
        }else if(obj instanceof InputStream){
            in=(InputStream)obj;
            FileOutputStream file=new FileOutputStream("data");
            byte[] buff=new byte[1024];
            int len=-1;

            while((len=in.read(buff))!=-1){
                file.write(buff,0,len);
            }

            System.out.println("正文保存完毕");
        }else{
            System.out.println("未知的响应正文类型");
        }
    }
}
