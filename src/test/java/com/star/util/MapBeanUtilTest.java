package com.star.util;

import com.star.entity.Speach;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

@Ignore
public class MapBeanUtilTest {
    @Test
    public void beanToMap() throws Exception {
        Speach speach=new Speach();
        speach.setId(1);
        speach.setDescription("这是测试描述");
        speach.setTime(new Date());
        speach.setPlace("思学楼A118");
        speach.setTitle("热爱祖国思想教育活动");
        Map<String,Object> map=MapBeanUtil.beanToMap(speach);
        for (String key:map.keySet()){
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }
    }

    @Test
    public void mapToBean() throws Exception {
    }

    @Test
    public void objectsToMaps() throws Exception {
    }

    @Test
    public void mapsToObjects() throws Exception {
    }

}