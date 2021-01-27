package com.example.steel.mapper;

import com.example.steel.util.QueryHomeBox;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author:zh
 * @date:Created in 18:47 2021/1/19
 * @desc
 */
@Repository
public interface SteelCommodityMapper {

    int steelCount(@Param("queryHomeBox") QueryHomeBox queryHomeBox);

    List<Map<String,Object>> steelList(@Param("queryHomeBox")QueryHomeBox queryHomeBox,@Param("today") String today,@Param("yesterday") String yesterday);

    int historyCount(@Param("queryHomeBox")QueryHomeBox queryHomeBox);

    List<Map<String,Object>> historyList(@Param("queryHomeBox")QueryHomeBox queryHomeBox);

    int addSteel(Map map);

    int addSteelCount(String name);

    int addSteelPrice(Map map);

    int addSteelPriceCount(Map map);

    int updatePrice(Map map);

    String getYesterdayPrice(@Param("yesterday") String yesterday,@Param("productId") String productId);

    int listTypeCount(@Param("queryHomeBox") QueryHomeBox queryHomeBox);

    List<Map<String,Object>> listType(@Param("queryHomeBox") QueryHomeBox queryHomeBox);

    int addType(Map map);

    int queryTypeCount(String name);

    int queryUpdateTypeCount(Map map);

    int updateType(Map map);

    int updateSteelCount(Map map);

    int updateSteel(Map map);

    int addList(Map map);

    int addPriceList(List<Map<String,Object>> list);

    int delete(String id);

    int deletePrice(String id);

    int queryType(String id);

    int deleteType(String id);

    Map<String,Object> queryYesPrice(String id);





}
