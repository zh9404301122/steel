package com.example.steel.service.ImpI;

import com.example.steel.mapper.SteelCommodityMapper;
import com.example.steel.service.SteelCommodityService;
import com.example.steel.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author:zh
 * @date:Created in 18:45 2021/1/19
 * @desc
 * 事务添加
 */
@Transactional
@Service
public class SteelCommodityServiceImpl implements SteelCommodityService {

    @Autowired
    private SteelCommodityMapper steelCommodityMapper;

    /**
     * 查询列表接口
     * @param queryHomeBox
     * @return
     */
    @Override
    public ResponseBox steelList(QueryHomeBox queryHomeBox) {
        //查询总条数
        int i = steelCommodityMapper.steelCount(queryHomeBox);
        queryHomeBox.setTotalCount(i);
        List<Map<String, Object>> list = steelCommodityMapper.steelList(queryHomeBox, DateUtils.getToday(), DateUtils.getYesterday());
        //昨日价格直接
        for(Map<String,Object> map :list){
            Map<String, Object> mapPrice = steelCommodityMapper.queryYesPrice(map.get("id").toString());
            map.put("yesterdayPrice",mapPrice.get("price").toString());
            System.out.println(mapPrice);
        }
        return new ResponseBox(list,queryHomeBox);
    }

    /**
     * 查询历史价格；
     * @param queryHomeBox
     * @return
     */
    @Override
    public ResponseBox historyList(QueryHomeBox queryHomeBox) {
        int i = steelCommodityMapper.historyCount(queryHomeBox);
        queryHomeBox.setTotalCount(i);
        List<Map<String, Object>> list = steelCommodityMapper.historyList(queryHomeBox);
        for(Map<String,Object> map :list){
            BigDecimal bignum1 = new BigDecimal(map.get("situation").toString());
            BigDecimal bignum2 = new BigDecimal((map.get("price").toString()));
            BigDecimal bignum3 = bignum2.subtract(bignum1);
            map.put("yesterdayPrice",String.valueOf(bignum3));
        }
        return new ResponseBox(list,queryHomeBox);
    }

    /**
     * 新增产品
     * @param map
     * @return
     */
    @Override
    public ResponseBox addSteel(Map map) {
        ResponseBox responseBox = new ResponseBox();
        map.put("id", UUIDUtils.getUUid());
        //查询产品是否存在
        int a = steelCommodityMapper.addSteelCount(map.get("name").toString());
        if(a>0){
            responseBox.setMsg("产品已存在");
            responseBox.setSuccess(false);
        }else{
            steelCommodityMapper.addSteel(map);
            responseBox.setMsg("新增成功");
            responseBox.setSuccess(true);
        }
        return responseBox;
    }


    /**
     * 新增产品价格
     * @param map
     * @return
     */
    @Override
    public ResponseBox addSteelPrice(Map map) {
        ResponseBox responseBox = new ResponseBox();
        //判断今天价格是否已经添加;
        int a = steelCommodityMapper.addSteelPriceCount(map);
        if(a>0){
            String yesterday = DateUtils.getYesterday();
            String yesterdayPrice = steelCommodityMapper.getYesterdayPrice(yesterday, map.get("productId").toString());
            BigDecimal bignum1 = null;
            if(yesterdayPrice == null){
                bignum1 = new BigDecimal(0);
            }else {
                bignum1 = new BigDecimal(yesterdayPrice);
            }
            BigDecimal bignum2 = new BigDecimal((map.get("price").toString()));
            BigDecimal bignum3 = bignum2.subtract(bignum1);
            String value = String.valueOf(bignum3);
            map.put("situation",value);
            steelCommodityMapper.updatePrice(map);
            responseBox.setMsg("操作成功");
            responseBox.setSuccess(true);
        }else{
            map.put("id", UUIDUtils.getUUid());
            //获取昨日价格;
            String yesterday = DateUtils.getYesterday();
            String yesterdayPrice = steelCommodityMapper.getYesterdayPrice(yesterday, map.get("productId").toString());
            BigDecimal bignum1 = null;
            if(yesterdayPrice == null){
                bignum1 = new BigDecimal(0);
            }else {
                bignum1 = new BigDecimal(yesterdayPrice);
            }
            BigDecimal bignum2 = new BigDecimal((map.get("price").toString()));
            BigDecimal bignum3 = bignum2.subtract(bignum1);
            String value = String.valueOf(bignum3);
            map.put("situation",value);
            steelCommodityMapper.addSteelPrice(map);
            responseBox.setMsg("操作成功");
            responseBox.setSuccess(true);
        }
        return responseBox;
    }

    /**
     * 查询产品类型列表
     * @param queryHomeBox
     * @return
     */
    @Override
    public ResponseBox listType(QueryHomeBox queryHomeBox) {
       //查询总条数
        int i = steelCommodityMapper.listTypeCount(queryHomeBox);
        queryHomeBox.setTotalCount(i);
        List<Map<String, Object>> list = steelCommodityMapper.listType(queryHomeBox);
        return new ResponseBox(list,queryHomeBox);
    }

    /**
     * 新增产品类型
     * @param map
     * @return
     */
    @Override
    public ResponseBox addType(Map map) {
        ResponseBox responseBox = new ResponseBox();
        map.put("id",UUIDUtils.getUUid());
        map.put("createTime",DateUtils.getTodayTime());
        String name = map.get("name").toString();
        int i = steelCommodityMapper.queryTypeCount(name);
        if(i>0){
            responseBox.setMsg("产品类型已存在");
            responseBox.setSuccess(false);
        }else{
            steelCommodityMapper.addType(map);
            responseBox.setMsg("操作成功");
            responseBox.setSuccess(true);
        }
        return responseBox;
    }

    /**
     * 修改产品类型
     * @param map
     * @return
     */
    @Override
    public ResponseBox updateType(Map map) {
        ResponseBox responseBox = new ResponseBox();
        int i = steelCommodityMapper.queryUpdateTypeCount(map);
        if(i>0){
            responseBox.setMsg("产品类型已存在");
            responseBox.setSuccess(false);
        }else{
            steelCommodityMapper.updateType(map);
            responseBox.setMsg("操作成功");
            responseBox.setSuccess(true);
        }
        return responseBox;
    }

    /**
     * 修改产品
     * @param map
     * @return
     */
    @Override
    public ResponseBox updateSteel(Map map) {
        ResponseBox responseBox = new ResponseBox();
        int i = steelCommodityMapper.updateSteelCount(map);
        if(i>0){
            responseBox.setMsg("产品类型已存在");
            responseBox.setSuccess(false);
        }else{
            steelCommodityMapper.updateSteel(map);
            responseBox.setMsg("操作成功");
            responseBox.setSuccess(true);
        }
        return responseBox;
    }

    /**
     * 爬虫数据接收
     * @param mapList
     * @return
     */
    @Override
    public ResponseBox addList(List<Map<String, Object>> mapList) {
        ResponseBox responseBox = new ResponseBox();
        String uUid = UUIDUtils.getUUid();
        for(Map<String,Object> map:mapList){
            map.put("id",uUid);
        }
        Map<String, Object> map = mapList.get(0);
        steelCommodityMapper.addList(map);
        //价格批量入库；
        steelCommodityMapper.addPriceList(mapList);
        return responseBox;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ResponseBox delete(String id) {
        ResponseBox responseBox = new ResponseBox();
        int delete = steelCommodityMapper.delete(id);
        return new ResponseBox(delete);
    }

    /**
     * 删除产品类型
     * @param id
     * @return
     */
    @Override
    public ResponseBox deleteType(String id) {
        ResponseBox responseBox = new ResponseBox();
        //查询是否存在产品;
        int i = steelCommodityMapper.queryType(id);
        if (i > 0) {
            responseBox.setSuccess(false);
            responseBox.setMsg("该类型下存在产品，无法删除");
        }else{
            steelCommodityMapper.deleteType(id);
            responseBox.setSuccess(true);
            responseBox.setMsg("操作成功");
        }
        return responseBox;
    }
}
