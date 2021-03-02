/**
 * Copyright (c) 2015-2016, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gaoce.whatever;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * 高频方法集合类
 */
public class ToolUtil {

	private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 获取随机位数的字符串
     *
     * @author fengshuonan
     * @Date 2017/8/24 14:09
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取异常的具体信息
     *
     * @author fengshuonan
     * @Date 2017/3/30 9:21
     * @version 2.0
     */
    public static String getExceptionMsg(Exception e) {
        StringWriter sw = new StringWriter();
        try {
            e.printStackTrace(new PrintWriter(sw));
        } finally {
            try {
                sw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return sw.getBuffer().toString().replaceAll("\\$", "T");
    }

    /**
     * 比较两个对象是否相等。<br>
     * 相同的条件有两个，满足其一即可：<br>
     * 1. obj1 == null && obj2 == null; 2. obj1.equals(obj2)
     *
     * @param obj1 对象1
     * @param obj2 对象2
     * @return 是否相等
     */
    public static boolean equals(Object obj1, Object obj2) {
        return (obj1 != null) ? (obj1.equals(obj2)) : (obj2 == null);
    }

    /**
     * 计算对象长度，如果是字符串调用其length函数，集合类调用其size函数，数组调用其length属性，其他可遍历对象遍历计算长度
     *
     * @param obj 被计算长度的对象
     * @return 长度
     */
    public static int length(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length();
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).size();
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).size();
        }

        int count;
        if (obj instanceof Iterator) {
            Iterator<?> iter = (Iterator<?>) obj;
            count = 0;
            while (iter.hasNext()) {
                count++;
                iter.next();
            }
            return count;
        }
        if (obj instanceof Enumeration) {
            Enumeration<?> enumeration = (Enumeration<?>) obj;
            count = 0;
            while (enumeration.hasMoreElements()) {
                count++;
                enumeration.nextElement();
            }
            return count;
        }
        if (obj.getClass().isArray() == true) {
            return Array.getLength(obj);
        }
        return -1;
    }

    /**
     * 对象中是否包含元素
     *
     * @param obj     对象
     * @param element 元素
     * @return 是否包含
     */
    public static boolean contains(Object obj, Object element) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            if (element == null) {
                return false;
            }
            return ((String) obj).contains(element.toString());
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).contains(element);
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).values().contains(element);
        }

        if (obj instanceof Iterator) {
            Iterator<?> iter = (Iterator<?>) obj;
            while (iter.hasNext()) {
                Object o = iter.next();
                if (equals(o, element)) {
                    return true;
                }
            }
            return false;
        }
        if (obj instanceof Enumeration) {
            Enumeration<?> enumeration = (Enumeration<?>) obj;
            while (enumeration.hasMoreElements()) {
                Object o = enumeration.nextElement();
                if (equals(o, element)) {
                    return true;
                }
            }
            return false;
        }
        if (obj.getClass().isArray() == true) {
            int len = Array.getLength(obj);
            for (int i = 0; i < len; i++) {
                Object o = Array.get(obj, i);
                if (equals(o, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 对象是否不为空(新增)
     *
     * @param o String,List,Map,Object[],int[],long[]
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    /**
     * 对象是否为空
     *
     * @param o String,List,Map,Object[],int[],long[]
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            if (o.toString().trim().equals("")) {
                return true;
            }
        } else if (o instanceof List) {
            if (((List) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Set) {
            if (((Set) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Object[]) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof int[]) {
            if (((int[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof long[]) {
            if (((long[]) o).length == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象组中是否存在 Empty Object
     *
     * @param os 对象组
     * @return
     */
    public static boolean isOneEmpty(Object... os) {
        for (Object o : os) {
            if (isEmpty(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象组中是否全是 Empty Object
     *
     * @param os
     * @return
     */
    public static boolean isAllEmpty(Object... os) {
        for (Object o : os) {
            if (!isEmpty(o)) {
                return false;
            }
        }
        return true;
    }
    /**
     * 对象组都不是empty
     */
    public static boolean isNotAllEmpty(Object... obj){
        for (Object o:obj){
            if (isEmpty(o)){
                return false;
            }
        }
        return true;
    }

    /**
     * 是否为数字
     *
     * @param obj
     * @return
     */
    public static boolean isNum(Object obj) {
        try {
            Integer.parseInt(obj.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 如果为空, 则调用默认值
     *
     * @param str
     * @return
     */
    public static Object getValue(Object str, Object defaultValue) {
        if (isEmpty(str)) {
            return defaultValue;
        }
        return str;
    }

    /**
     * 强转->string,并去掉多余空格
     *
     * @param str
     * @return
     */
    public static String toStr(Object str) {
        return toStr(str, "");
    }

    /**
     * 强转->string,并去掉多余空格
     *
     * @param str
     * @param defaultValue
     * @return
     */
    public static String toStr(Object str, String defaultValue) {
        if (null == str) {
            return defaultValue;
        }
        return str.toString().trim();
    }

    /**
     * 强转->int
     *
     * @param obj
     * @return
     */
//	public static int toInt(Object value) {
//		return toInt(value, -1);
//	}

    /**
     * 强转->int
     *
     * @param obj
     * @param defaultValue
     * @return
     */
//	public static int toInt(Object value, int defaultValue) {
//		return Convert.toInt(value, defaultValue);
//	}

    /**
     * 强转->long
     *
     * @param obj
     * @return
     */
//	public static long toLong(Object value) {
//		return toLong(value, -1);
//	}

    /**
     * 强转->long
     *
     * @param obj
     * @param defaultValue
     * @return
     */
//	public static long toLong(Object value, long defaultValue) {
//		return Convert.toLong(value, defaultValue);
//	}
//
//	public static String encodeUrl(String url) {
//		return URLKit.encode(url, CharsetKit.UTF_8);
//	}
//
//	public static String decodeUrl(String url) {
//		return URLKit.decode(url, CharsetKit.UTF_8);
//	}

    /**
     * map的key转为小写
     *
     * @param map
     * @return Map<String,Object>
     */
    public static Map<String, Object> caseInsensitiveMap(Map<String, Object> map) {
        Map<String, Object> tempMap = new HashMap<>();
        for (String key : map.keySet()) {
            tempMap.put(key.toLowerCase(), map.get(key));
        }
        return tempMap;
    }

    /**
     * 获取map中第一个数据值
     *
     * @param <K> Key的类型
     * @param <V> Value的类型
     * @param map 数据源
     * @return 返回的值
     */
    public static <K, V> V getFirstOrNull(Map<K, V> map) {
        V obj = null;
        for (Entry<K, V> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }

    /**
     * 创建StringBuilder对象
     *
     * @return StringBuilder对象
     */
    public static StringBuilder builder(String... strs) {
        final StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb;
    }

    /**
     * 创建StringBuilder对象
     *
     * @return StringBuilder对象
     */
    public static void builder(StringBuilder sb, String... strs) {
        for (String str : strs) {
            sb.append(str);
        }
    }

    /**
     * 去掉指定后缀
     *
     * @param str    字符串
     * @param suffix 后缀
     * @return 切掉后的字符串，若后缀不是 suffix， 返回原字符串
     */
    public static String removeSuffix(String str, String suffix) {
        if (isEmpty(str) || isEmpty(suffix)) {
            return str;
        }

        if (str.endsWith(suffix)) {
            return str.substring(0, str.length() - suffix.length());
        }
        return str;
    }

    /**
     * 判断是否是windows操作系统
     *
     * @author stylefeng
     * @Date 2017/5/24 22:34
     */
    public static Boolean isWinOs() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取临时目录
     *
     * @author stylefeng
     * @Date 2017/5/24 22:35
     */
    public static String getTempPath() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     * 把一个数转化为int
     *
     * @author fengshuonan
     * @Date 2017/11/15 下午11:10
     */
    public static Integer toInt(Object val) {
        if (val instanceof Double) {
            BigDecimal bigDecimal = new BigDecimal((Double) val);
            return bigDecimal.intValue();
        } else {
            return Integer.valueOf(val.toString());
        }

    }

    /**
     * 获取项目路径
     */
    public static String getWebRootPath(String filePath) {
        try {
            String path = ToolUtil.class.getClassLoader().getResource("").toURI().getPath();
            path = path.replace("/WEB-INF/classes/", "");
            path = path.replace("/target/classes/", "");
            path = path.replace("file:/", "");
            if (ToolUtil.isEmpty(filePath)) {
                return path;
            } else {
                return path + "/" + filePath;
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     *
     * 转义特殊字符 入库
     * @param cfgKeywords
     * @return
     */
    public static String strEscape(String cfgKeywords,Boolean... flag) {
		if (StringUtils.isNotEmpty(cfgKeywords)) {
			cfgKeywords = cfgKeywords.trim();// 首先去掉空白符号
			// 不能输入不可见字符
			if(containsInvisibleChar(cfgKeywords)) {
//				throw new NtcException(Code.InvisibleChar.getCode(),Code.InvisibleChar.getDesc()+": "+cfgKeywords);
			}
			 // \\ 需要第一个替换
//            String[] fbsArr = { "\\","$","(",")","*","+",".","?","^","|","'","%","&"};

//			cfgKeywords=flag.length>0&&flag[0]?cfgKeywords:cfgKeywords.replace("\\", "\\\\");
            cfgKeywords=cfgKeywords.replace("\\", "\\\\").replace("&", "\\&")
			.replace(" ", "\\b");
		}
		return cfgKeywords;
	}


    /**
     *
     * 入库字段\处理查询入库
     * @param cfgKeywords
     * @return
     */
    public static String strGetEscape(String cfgKeywords) {
        if (StringUtils.isNotEmpty(cfgKeywords)) {
            cfgKeywords = cfgKeywords.trim();// 首先去掉空白符号
            // 不能输入不可见字符
            if(containsInvisibleChar(cfgKeywords)) {
                //zdx???
//                throw new NtcException(Code.InvisibleChar.getCode(),Code.InvisibleChar.getDesc()+": "+cfgKeywords);
            }
            // \\ 需要第一个替换
//            String[] fbsArr = { "\\","$","(",")","*","+",".","?","^","|","'","%","&"};
            cfgKeywords=cfgKeywords.replace("\\", "\\\\")
                    .replace("&", "_&")
                    .replace(" ", "_b");
        }
        return cfgKeywords;
    }


    /**
     *
     * 反转义特殊字符 出库
     * @param cfgKeywords
     * @return
     */
    public static String strUnEscape(String cfgKeywords,Boolean... flag) {
		if (StringUtils.isNotEmpty(cfgKeywords)) {
			// 不转译特殊字符
            cfgKeywords = cfgKeywords.trim();// 首先去掉首尾空格
            if(flag.length>0&&flag[0]){
                /**因为入库前空格要转换成了\b;但如果输入的是\b而不是空格，入库后就是\\b，这时在反转时不需要处理，
                * 在查询的时候要将\b转反换回空格，需要对\\b提前处理，否则会误转
                 * * split本身对\需要转义，最终\\b写成了8个\
                */
                String []cfgKeywordAry = cfgKeywords.split("\\\\\\\\b",-1);
                String tempKeywords = "";
                for (String str:cfgKeywordAry) {
                    str = str.replace("\\b", " ");
                    tempKeywords+=str+"\\\\b";
                }
                if (tempKeywords.endsWith("\\\\b")){
                    cfgKeywords =tempKeywords.substring(0,tempKeywords.lastIndexOf("\\\\b"));
                }
                cfgKeywords= cfgKeywords.indexOf("\\\\b")==-1?cfgKeywords.replace("\\b", " "):cfgKeywords;
            }else{
                String [] tempStr = cfgKeywords.split("\\\\\\\\b",-1);
                String tempKwd  = "";
                for (String str:tempStr) {
                    str=str.replace("\\b","\b");
                    tempKwd += str+"\\\\b";
                }
                if (tempKwd.endsWith("\\\\b")){
                    cfgKeywords =tempKwd.substring(0,tempKwd.lastIndexOf("\\\\b"));
                }
                char[] chars = cfgKeywords.toCharArray();
                StringBuilder sb=new StringBuilder();
                for (char aChar : chars) {
                    if(aChar=='\b'){
                        sb.append(" ");
                    }else{
                        sb.append( aChar);}
                }
                cfgKeywords = sb.toString();

            }
            cfgKeywords = cfgKeywords.replace("\\\\", "\\");
            cfgKeywords=cfgKeywords.replace("\\&", "&");
		}
		return cfgKeywords;
	}
    /**
     * 获取指定字符串出现的次数
     * @param srcText 源字符串
     * @param findText 要查找的字符串
     * @return
     */
	public static int appearNumber(String srcText, String findText) {
		int count = 0;
		if (StringUtils.isNotEmpty(srcText)) {
			int index = 0;
			while ((index = srcText.indexOf(findText, index)) != -1) {
				index = index + findText.length();
				count++;
			}
		}
		return count;
	}
	/**
	 * 字符串是否包含不可见字符
	 * 包含：true
	 * 不包含：false
	 * @param content
	 * @return Boolean
	 */
	public static Boolean containsInvisibleChar(String content) {
		if (content != null && content.length() > 0) {
			char[] contentCharArr = content.toCharArray();
			for (int i = 0; i < contentCharArr.length; i++) {
				if ((contentCharArr[i] <= 0x1F) || contentCharArr[i] == 0x7F) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	/**
	 * 字符串只包含：英文字母，数字，下划线_，减号-，英文点(.)
	 * 包含以上指定内容以外的特殊字符：true
	 * 不包含以上指定内容以外的特殊字符：false
	 * @param content
	 * @return Boolean
	 */
	public static Boolean containsSpecialChar(String content) {
		String regex = "^[a-z0-9A-Z_\\-\\.]+$";
		boolean isRightPattern = content.matches(regex);
		return !isRightPattern;
	}

    /**
     * 获取Annotation 中 memberValues的值
     *
     * @param object
     * @param property
     * @param <T>
     * @return
     */
    public static <T> Object getFieldValue(T object, String property) {
        if (object != null && property != null) {
            Class<T> currClass = (Class<T>) object.getClass();
            try {
                Field field = currClass.getDeclaredField(property);
                field.setAccessible(true);
                return field.get(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	/**
	 * //递归获取cls实体对象及父级对象的属性 wx:修改，子类覆盖父类的同名方法
	 *
	 * @param list
	 * @param cls
	 */
	public static void getFields(List<Field> list, Class<?> cls) {
		Field[] fields = cls.getDeclaredFields();
		if (fields != null && fields.length > 0) {
			List<Field> tempList = new ArrayList<>();
			for (Field field : fields) {
				if (list.size() == 0) {
					tempList.add(field);
				} else {
					boolean has = false;
					for (Field checkF : list) {
						if (checkF.getName().equals(field.getName())) {
							has = true;
							break;
						}
					}
					if (!has) {
						tempList.add(field);
					}
				}
			}
			list.addAll(tempList);
		}
		if (cls.getSuperclass() != null) {
			getFields(list, cls.getSuperclass());
		}
	}
	
	/*
	 * 字符串数组转换为数值型数组
	 */
	public static Integer[] getIntegerArray(String[] strArray) {
        Integer[] riskArray = new Integer[strArray.length];
        for(int i=0;i<strArray.length;i++) {
        	if(ToolUtil.isNotEmpty(strArray[i])){
        		riskArray[i] = Integer.parseInt(strArray[i]);
        	}
        }
        return riskArray;
    }
}
