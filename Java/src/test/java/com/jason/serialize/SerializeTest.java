package com.jason.serialize;

import com.jason.serialize.model.UserRequest;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/8/19 17:28
 * @Description:
 */
public class SerializeTest {

    /**
     * 测试序列化
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void test_serialize() throws IOException, ClassNotFoundException {
        String filePath = "file.txt";
        /**序列化*/
        FileOutputStream fos = new FileOutputStream(filePath);
        UserRequest userRequest = new UserRequest("qh");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userRequest);
        oos.flush();
        oos.close();
        /**反序列化*/
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        UserRequest readObject = (UserRequest) ois.readObject();
        ois.close();
        Assert.assertEquals("qh", readObject.getName());
    }

    /**
     * 反序列化时增加字段
     * 在UserRequest增加age字段
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void test_update() throws IOException, ClassNotFoundException {
        String filePath = "file.txt";
        /**反序列化*/
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        UserRequest readObject = (UserRequest) ois.readObject();
        ois.close();
        Assert.assertEquals("qh", readObject.getName());
        Assert.assertEquals(0, readObject.getAge());
    }

    /**
     * 序列化时增加字段
     * 在UserRequest删除name字段
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void test_update2() throws IOException, ClassNotFoundException {
        String filePath = "file.txt";
        /**反序列化*/
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        UserRequest readObject = (UserRequest) ois.readObject();
        ois.close();
        Assert.assertEquals(0, readObject.getAge());
    }

}
