package com.gaoce.whatever;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
@Slf4j
public class 测试stringutils {

    public static String SOURCE_AREA_LV1 = "area_lv1";
    public static String SOURCE_AREA_LV2 = "area_lv2";
    public static String SOURCE_AREA_LV3 = "area_lv3";

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.set("area_lv3",1);


        String mes = "配置格式错误！";
        String s = null;
        boolean b = checkParam(jsonObject.get("area_lv3"), mes + SOURCE_AREA_LV1, 1, null, false);
        System.out.println(b);
        if (0==(int)jsonObject.get("area_lv3")){
            System.out.println("真好");
        }else {
            System.out.println("不好");
        }
    }

    /**
     *  校验参数正确性
     * @param param             参数值
     * @param msg               描述信息
     * @param paramType         参数类型   0 字符类型  1 Integer类型  2 List
     * @param paramMaxLength    参数最大长度  为null则不校验该项
     * @param nullable          参数是否允许空值 true 允许  false 不允许
     * @param params    参数最小长度  为null则不校验该项
     * @return
     */
    public static boolean checkParam(Object param, String msg, int paramType, Integer paramMaxLength, boolean nullable, Integer... params) {
        if (StringUtils.isNullOrEmpty(param)) {
            if (!nullable) {
                log.error(msg + "字段为空");
                return false;
            }
        } else {
            if (paramType == 0) {
                if (!(param instanceof CharSequence)) {
                    log.error(msg + "字段数据类型不正确");
                    return false;
                }
            } else if (paramType == 1){
                if (!(param instanceof Integer)) {
                    log.error(msg + "字段数据类型不正确");
                    return false;
                }
            } else if (paramType == 2){
                if (!(param instanceof Collection)) {
                    log.error(msg + "字段数据类型不正确");
                    return false;
                }
            }
            if (paramMaxLength != null) {
                if (ToolUtil.length(param) > paramMaxLength) {
                    log.error(msg + "字段长度大于" + paramMaxLength);
                    return false;
                }
            }
            if (params != null && params.length > 0) {
                Integer sfbds = params[0];
                if (sfbds ==0) {
                    if (ToolUtil.length(param) < params[1]) {
                        log.error(msg + "字段长度小于" + params[1]);
                        return false;
                    }
                } else if (sfbds ==1) {
                    if (param.toString().startsWith(StringPool.DOT) || param.toString().endsWith(StringPool.SLASH)
                            || param.toString().startsWith(StringPool.TILDA)) {
                        if (ToolUtil.length(param)-1 < params[1]) {
                            log.error(msg + "字段长度小于" + params[1]);
                            return false;
                        }
                    } else if (param.toString().contains(StringPool.HAT)) {
                        String[] arr = param.toString().split("\\^");
                        JSONArray keywordArray = new JSONArray();
                        int num = 0;
                        for (int i =0 ;i<arr.length;i++) {
                            if (StringUtils.isNotNullOrEmpty(arr[i])) {
                                keywordArray.add(arr[i]);
                                num +=arr[i].length();
                            }
                        }
                        if (num < params[1]) {
                            log.error(msg + "字段长度小于" + params[1]);
                            return false;
                        }
                        if (keywordArray.size()>4) {
                            log.error(msg+ "字段最多添加4个子串关键字");
                            return false;
                        }
                        // 子串
                    } else {
                        if (ToolUtil.length(param) < params[1]) {
                            log.error(msg + "字段长度小于" + params[1]);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
