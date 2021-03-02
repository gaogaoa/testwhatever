package com.gaoce.whatever;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author wx
 */
@Slf4j
@Component("ConfigUtils")
//确保该组件加载顺序优先于HttpClientUtil
@Order(Integer.MIN_VALUE)
public class ConfigUtils {
    /**
     * httpclient相关
     */
    public static int RETRYTIMES;
    public static int MAXTOTAL;
    public static int MAXPERROUTE;
    public static int CONNECTTIMEOUT;
    public static int CONNECTIONREQUESTTIMEOUT;
    public static int SOCKETTIMEOUT;


    @Value("${httpClient.connectionManager.maxTotal}")
    public void setMaxTotal(int maxTotal) {
        MAXTOTAL = maxTotal;
    }
    @Value("${httpClient.connectionManager.maxaxPerRoute}")
    public void setMaxPerRoute(int maxPerRoute) {
        MAXPERROUTE = maxPerRoute;
    }
    @Value("${httpClient.retryTimes}")
    public void setRetryTimes(int retryTimes) {
        RETRYTIMES = retryTimes;
    }
    @Value("${httpClient.connectTimeout}")
    public void setConnectTimeout(int connectTimeout) {
        CONNECTTIMEOUT = connectTimeout;
    }
    @Value("${httpClient.connectionRequestTimeout}")
    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        CONNECTIONREQUESTTIMEOUT = connectionRequestTimeout;
    }
    @Value("${httpClient.socketTimeout}")
    public void setSocketTimeout(int socketTimeout) {
        SOCKETTIMEOUT = socketTimeout;
    }

    /**
     *
     */
    public static String NORTHSTAR_BASEURL;

    @Value("${northstar.baseUrl}")
    public void setNorthstarBaseUrl(String url){
        NORTHSTAR_BASEURL = url;
    }

    public static long DELAY;

    @Value("${date.delay}")
    public void setDelay(long delay){
        DELAY = delay;
    }
    public static long INTERVAL;

    @Value("${date.interval}")
    public void setInterval(long interval){
        INTERVAL = interval;
    }
    public static long USER_ID;
    @Value("${nis.creator.id}")
    public void setUserId(long userId){
        USER_ID = userId;
    }

    public static String USER_NAME;
    @Value("${nis.creator.name}")
    public void setUserName(String userName){
        USER_NAME = userName;
    }
    public static String LOG_TYPE;
    @Value("${nis.log.type}")
    public void setLogType(String logType){LOG_TYPE = logType;}




    public static String TIME_TO;
    @Value("${nis.log.timeto}")
    public void setTimeTo(String totime){TIME_TO = totime;}

    public static String NET;
    @Value("${nis.log.net}")
    public void setNET(String net){NET = net;}

    public static String FIELDS;
    @Value("${nis.log.field}")
    public void setFIELDS(String fields){FIELDS = fields;}

    public static String TG;
    @Value("${nis.log.tg}")
    public void setTG(String tg){TG = tg;}

 //   public static String VTYPE;
//    @Value("${nis.log.vtype}")
//    public void setVTYPE(String vtype){VTYPE = vtype;}
    public static String OFFSET;
    @Value("${nis.log.offset}")
    public void setOFFSET(String offset){OFFSET = offset;}
    public static String LIMIT;
    @Value("${nis.log.limit}")
    public void setLIMIT(String limit){LIMIT = limit;}


    public static int LOG_STORE;
    @Value("${nis.log.store}")
    public void setLogStore(int logStore){LOG_STORE = logStore;}

    public static Boolean HOST_IP_SEARCH;
    @Value("${nis.log.host.ip}")
    public void setHostIpSearch(boolean hostIpSearch){HOST_IP_SEARCH = hostIpSearch;}

    public static Boolean HOST_NET_SEARCH;
    @Value("${nis.log.host.net}")
    public void setHostNetSearch(boolean hostNetSearch){HOST_NET_SEARCH = hostNetSearch;}

    public static Boolean PORT_IP_SEARCH;
    @Value("${nis.log.port.ip}")
    public void setPortIpSearch(boolean portIpSearch){PORT_IP_SEARCH = portIpSearch;}

    public static Boolean PORT_NET_SEARCH;
    @Value("${nis.log.port.net}")
    public void setPortNetSearch(boolean portNetSearch){PORT_NET_SEARCH = portNetSearch;}

    public static Boolean PORT_PORT_SEARCH;
    @Value("${nis.log.port.port}")
    public void setPortPortSearch(boolean portPortSearch){PORT_PORT_SEARCH = portPortSearch;}

    public static Boolean USE_CACHE;
    @Value("${nis.cache.use}")
    public void setUseCache(boolean useCache){USE_CACHE = useCache;}

    public static Boolean SAVE_LOG_TO_CLICKHOUSE;
    @Value("${nis.clickhouse.save_log_to}")
    public void setSaveLogToClickhouse(boolean saveLogToClickhouse){SAVE_LOG_TO_CLICKHOUSE = saveLogToClickhouse;}

    public static String CLICKHOUSE_DATABASE_PREFIX;
    @Value("${nis.clickhouse.database_prefix}")
    public void setClickhouseDatabasePrefix(String clickhouseDatabasePrefix){CLICKHOUSE_DATABASE_PREFIX = clickhouseDatabasePrefix;}




}
