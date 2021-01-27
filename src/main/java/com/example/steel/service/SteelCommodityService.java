package com.example.steel.service;

import com.example.steel.util.QueryHomeBox;
import com.example.steel.util.ResponseBox;

import java.util.List;
import java.util.Map;

/**
 * @author:zh
 * @date:Created in 18:44 2021/1/19
 * @desc
 */
public interface SteelCommodityService {

    //查询列表
    ResponseBox steelList(QueryHomeBox queryHomeBox);

    //查询历史价格;
    ResponseBox historyList(QueryHomeBox queryHomeBox);

    //新增产品
    ResponseBox addSteel(Map map);

    //新增产品价格
    ResponseBox addSteelPrice(Map map);

    //查询产品列表
    ResponseBox listType(QueryHomeBox queryHomeBox);

    //新增产品
    ResponseBox addType(Map map);

    //修改产类型
    ResponseBox updateType(Map map);

    //修改产品
    ResponseBox updateSteel(Map map);

    ResponseBox addList(List<Map<String,Object>> mapList);

    ResponseBox delete(String id);

    ResponseBox deleteType(String id);



}
