package com.star.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 座位实体工具类.
 */
public class SeatUtil {
    /**
     * 座位编号加工方法.
     * 将seatNum字符串分解，解析成用户友好的信息，并装入map返回
     * @param seatNum 座位标号
     * @return 包含作为信息的map.
     */
    public static Map<String,String> seatNumUtil(String seatNum){
        String[] seat=seatNum.split("_");
        Map<String,String> map=new HashMap<>();
        switch (seat[0]) {
            case "1":
                map.put("building", "图书馆报告厅");
                break;
            case "2":
                map.put("building", "思学楼A114");
                break;
            default:
                map.put("building", "艺术演播大厅");
                break;
        }
        map.put("floor",seat[1]);
        map.put("row",seat[2]);
        map.put("number",seat[3]);
        return map;
    }

}
