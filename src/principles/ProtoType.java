package principles;

import java.io.*;

/**
 * 原型模式
 * 用来解决克隆对象的问题
 */
public class ProtoType implements Cloneable {

    String name;
    int age;
    Proto proto;

    public ProtoType(String name, int age, Proto proto) {
        this.name = name;
        this.age = age;
        this.proto = proto;
    }

    @Override
    public String toString() {
        return "ProtoType{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", proto=" + proto +
                '}';
    }

    //浅拷贝：属性如果是引用类型，则拷贝出来的对象和原有的对象共享同一个引用类型
    @Override
    public ProtoType clone() throws CloneNotSupportedException {
        ProtoType protoType = (ProtoType) super.clone();
        return protoType;
    }

}


class DeepProtoType implements Serializable, Cloneable {

    String name;
    int age;
    Proto proto;

    public DeepProtoType(String name, int age, Proto proto) {
        this.name = name;
        this.age = age;
        this.proto = proto;
    }

    //深拷贝的两种方式：
    //1.重写clone方法:这种方法的缺点是如果引用类型太多的话就要写很多,不推荐
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        DeepProtoType protoType = (DeepProtoType) super.clone();
//        protoType.proto = this.proto.clone();
//        return protoType;
//    }

    //2.通过对象序列化实现
    @Override
    public Object clone() throws CloneNotSupportedException {

        //创建流对象
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;


        try{
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType deepProtoType =  (DeepProtoType) ois.readObject();

            return deepProtoType;

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                bis.close();
                bos.close();
                ois.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "DeepProtoType{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", proto=" + proto +
                '}';
    }


}

class Proto implements Serializable,Cloneable {

    String name;

    public Proto(String name) {
        this.name = name;
    }

    @Override
    public Proto clone() throws CloneNotSupportedException {
        return (Proto) super.clone();
    }

    @Override
    public String toString() {
        return "Proto{" +
                "name='" + name + '\'' +
                '}';
    }
}

class test {

    public static void main(String[] args) throws Exception {

        ProtoType protoType1 = new ProtoType("测试", 1, new Proto("附属"));
        ProtoType protoType2 = (ProtoType) protoType1.clone();

        System.out.println(protoType1 == protoType2);//false
        System.out.println(protoType1.proto == protoType2.proto);//true

        DeepProtoType deepProtoType1 = new DeepProtoType("测试",1,new Proto("附属"));
        DeepProtoType deepProtoType2 = (DeepProtoType) deepProtoType1.clone();

        System.out.println(deepProtoType1 == deepProtoType2);//false
        System.out.println(deepProtoType1.proto == deepProtoType2.proto);//false


    }
}




