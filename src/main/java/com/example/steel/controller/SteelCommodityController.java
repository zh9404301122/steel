package com.example.steel.controller;

import com.example.steel.service.SteelCommodityService;
import com.example.steel.util.QueryHomeBox;
import com.example.steel.util.ResponseBox;
import com.example.steel.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author:zh
 * @date:Created in 18:43 2021/1/19
 * @desc
 */
@Controller
@RequestMapping("/commodity")
public class SteelCommodityController {

    @Autowired
    private SteelCommodityService steelCommodityService;


    /**
     * 查询列表接口
     * @param queryHomeBox
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox list(@RequestBody QueryHomeBox queryHomeBox){
        return steelCommodityService.steelList(queryHomeBox);
    }

    /**
     * 查询历史价格接口;
     */
    @RequestMapping(value = "/historyList", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox historyList(@RequestBody QueryHomeBox queryHomeBox){
        return steelCommodityService.historyList(queryHomeBox);
    }


    /**
     * 新增产品接口
     */
    @RequestMapping(value = "/addSteel", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox addSteel(@RequestBody Map map){
        return steelCommodityService.addSteel(map);
    }

    /**
     * 新增价格数据
     */
    @RequestMapping(value = "/addSteelPrice", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox addSteelPrice(@RequestBody Map map){
        return steelCommodityService.addSteelPrice(map);
    }

    /**
     * 查询产品类型列表
     */
    @RequestMapping(value = "/listType", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox listType(@RequestBody QueryHomeBox queryHomeBox){
        return steelCommodityService.listType(queryHomeBox);
    }

    /**
     * 产品类型新增
     */
    @RequestMapping(value = "/addType", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox addType(@RequestBody Map map){
        return steelCommodityService.addType(map);
    }

    /**
     * 修改产品类型
     */
    @RequestMapping(value = "/updateType", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox updateType(@RequestBody Map map){
        return steelCommodityService.updateType(map);
    }

    /**
     * 修改产品
     */
    @RequestMapping(value = "/updateSteel", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox updateSteel(@RequestBody Map map){
        return steelCommodityService.updateSteel(map);
    }


    /**
     * 爬虫数据接收;
     */
    @RequestMapping(value = "/addList", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox addList(@RequestBody List<Map<String,Object>> list){
        return steelCommodityService.addList(list);
    }

    /**
     * 删除产品
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox delete(String id){
        return steelCommodityService.delete(id);
    }


    @RequestMapping(value = "/deleteType", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox deleteType(String id){
        return steelCommodityService.deleteType(id);
    }
}
