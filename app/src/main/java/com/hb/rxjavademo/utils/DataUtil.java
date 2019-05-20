package com.hb.rxjavademo.utils;

import com.hb.rxjavademo.model.OperatorModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author huangbiao
 * @data 2019 2019-05-18 22:18
 */
public class DataUtil {

    /**
     * 创建测试数据
     *
     * @return
     */
    public static final List<OperatorModel> createList() {
        List<OperatorModel> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new OperatorModel("model" + i));
        }
        return list;
    }


    /**
     * 创建测试数据
     *
     * @return
     */
    public static final OperatorModel[] createArray() {
        ArrayList<OperatorModel> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new OperatorModel("model" + i));
        }
        return list.toArray(new OperatorModel[list.size()]);
    }
}
