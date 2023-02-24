package com.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ParameterizedTypeClass {

    public void set(List<String> list) {
        System.out.println("a");
    }

    public void setNoParameterType(List list) {
        System.out.println("a");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method set = ParameterizedTypeClass.class.getDeclaredMethod("set", List.class);
        Type[] genericParameterTypes = set.getGenericParameterTypes();
        Type type = ((ParameterizedType) (genericParameterTypes[0])).getActualTypeArguments()[0];
        System.out.println(type.getTypeName());
    }

    /*
    public set(Ljava/util/List;)V
   L0
    LINENUMBER 8 L0
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    LDC "a"
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
   L1
    LINENUMBER 9 L1
    RETURN
   L2
    LOCALVARIABLE this Lcom/generic/ParameterizedTypeClass; L0 L2 0
    LOCALVARIABLE list Ljava/util/List; L0 L2 1
    //-----泛型方法使用 signature属性保存 类型参数 信息--------//
    // signature Ljava/util/List<Ljava/lang/String;>;
    // declaration: list extends java.util.List<java.lang.String>
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public setNoParameterType(Ljava/util/List;)V
   L0
    LINENUMBER 12 L0
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    LDC "a"
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
   L1
    LINENUMBER 13 L1
    RETURN
   L2
    LOCALVARIABLE this Lcom/generic/ParameterizedTypeClass; L0 L2 0
    LOCALVARIABLE list Ljava/util/List; L0 L2 1
    MAXSTACK = 2
    MAXLOCALS = 2
     */
}
