package com.generic;


/**
 * @description 泛型类 多态java是如何解决的
 */
public class ChildrenClass extends SuperClass<Integer> {

    private Integer value;

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }

    /*
    泛型类多态通过生成桥接方法解决
    byte code

    0 aload_0
    1 aload_1
    2 checkcast #4 <java/lang/Integer>
    5 invokevirtual #5 <com/generic/ChildrenClass.setValue>
    8 return

    public void setValue(Object value) {
        ChildrenClass.this.setValue((Integer) value);
    }*/
}
