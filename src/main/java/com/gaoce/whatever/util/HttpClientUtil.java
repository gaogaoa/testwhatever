package com.gaoce.whatever.util;

import com.alibaba.fastjson.JSON;

import com.gaoce.whatever.ConfigUtils;
import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wx
 *
 *         <dependency>
 *             <groupId>org.apache.httpcomponents</groupId>
 *             <artifactId>httpclient</artifactId>
 *             <version>4.5.6</version>
 *         </dependency>
 */
@Slf4j
@Component("HttpClientUtil")
@DependsOn("ConfigUtils")
public class HttpClientUtil {


//public static int RETRYTIMES;
//    public static int MAXTOTAL;
//    public static int MAXPERROUTE;
//    public static int CONNECTTIMEOUT;
//    public static int CONNECTIONREQUESTTIMEOUT;
//    public static int SOCKETTIMEOUT;
//
//
//    @Value("${httpClient.connectionManager.maxTotal}")
//    public void setMaxTotal(int maxTotal) {
//        MAXTOTAL = maxTotal;
//    }
//    @Value("${httpClient.connectionManager.maxaxPerRoute}")
//    public void setMaxPerRoute(int maxPerRoute) {
//        MAXPERROUTE = maxPerRoute;
//    }
//    @Value("${httpClient.retryTimes}")
//    public void setRetryTimes(int retryTimes) {
//        RETRYTIMES = retryTimes;
//    }
//    @Value("${httpClient.connectTimeout}")
//    public void setConnectTimeout(int connectTimeout) {
//        CONNECTTIMEOUT = connectTimeout;
//    }
//    @Value("${httpClient.connectionRequestTimeout}")
//    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
//        CONNECTIONREQUESTTIMEOUT = connectionRequestTimeout;
//    }
//    @Value("${httpClient.socketTimeout}")
//    public void setSocketTimeout(int socketTimeout) {
//        SOCKETTIMEOUT = socketTimeout;
//    }


    public static final int SUCCESS_CODE = 200;
    public static final int INIT_CODE = 400;
    /**
     * 创建HttpClient对象
     */

    private static final CloseableHttpClient httpClient = createHttpClient();
    /**
     * 初始化httpclient
     *
     * @return
     */
    public static CloseableHttpClient createHttpClient() {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainsf).register("https", sslsf).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
        // 设置整个连接池最大连接数
        cm.setMaxTotal(ConfigUtils.MAXTOTAL);
        // 设置路由的最大连接数
        cm.setDefaultMaxPerRoute(ConfigUtils.MAXPERROUTE);
        // HttpHost httpHost = new HttpHost(hostname, port);
        // 为某个站点设置最大连接数
        // cm.setMaxPerRoute(new HttpRoute(httpHost), 20);

        // 请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount >= ConfigUtils.RETRYTIMES) {// 如果已经重试了5次，就放弃
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
                    return false;
                }
                if (exception instanceof InterruptedIOException) {// 超时
                    return false;
                }
                if (exception instanceof UnknownHostException) {// 目标服务器不可达
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
                    return false;
                }
                if (exception instanceof SSLException) {// SSL握手异常
                    return false;
                }

//                HttpClientContext clientContext = HttpClientContext.adapt(context);
//                HttpRequest request = clientContext.getRequest();
//                // 如果请求是幂等的，就再次尝试
//                if (!(request instanceof HttpEntityEnclosingRequest)) {
//                    return true;
//                }
                return false;
            }
        };

        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm)
                .setRetryHandler(httpRequestRetryHandler).build();

        return httpClient;
    }

    /**
     * 获取HttpClient对象
     *
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
        return httpClient;
    }
    public static String doGet(String url, Map<String, String> param) throws Exception {
        HttpGet httpGet = null;
        String resultString = "";
        Integer resCode = INIT_CODE;
        CloseableHttpResponse response = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);

            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            if(log.isDebugEnabled()){
                log.debug("Request URI: " + uri);
            }

            // 创建http GET请求
            httpGet = new HttpGet(uri);
            httpGet.setConfig(RequestConfig.custom()
                    .setConnectTimeout(ConfigUtils.CONNECTTIMEOUT)
                    .setConnectionRequestTimeout(ConfigUtils.CONNECTIONREQUESTTIMEOUT)
                    .setSocketTimeout(ConfigUtils.SOCKETTIMEOUT).build());
            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200
            resCode = response.getStatusLine().getStatusCode();
            if (resCode == SUCCESS_CODE) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }else {
                String message=String.format("request service failed,code is %s,response is %s",resCode,response);
                throw new Exception(message);
            }
        } catch (Exception e) {
            log.error("doGet()", e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                //httpClient.close();
            } catch (IOException e) {
                log.error("close()", e);
            }
        }
        return resultString;
    }

    public static String doGet(String url) throws Exception {
        return doGet(url, null);
    }

    public static String doPost(String url, Map<String, String> param) throws Exception {
        HttpPost httpPost = null;
        String resultString = "";
        Integer resCode = INIT_CODE;
        CloseableHttpResponse response = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 创建Http Post请求
            httpPost = new HttpPost(url);
            httpPost.setConfig(RequestConfig.custom()
                    .setConnectTimeout(ConfigUtils.CONNECTTIMEOUT)
                    .setConnectionRequestTimeout(ConfigUtils.CONNECTIONREQUESTTIMEOUT)
                    .setSocketTimeout(ConfigUtils.SOCKETTIMEOUT).build());
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"UTF-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);

            // 判断返回状态是否为200
            resCode = response.getStatusLine().getStatusCode();
            if (resCode == SUCCESS_CODE) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }else {
                String message=String.format("request service failed,code is %s,response is %s",resCode,response);
                throw new Exception(message);
            }
        } catch (Exception e) {
            log.error("doPost()", e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error("close()", e);
            }
        }
        return resultString;
    }

    public static String doPost(String url) throws Exception {
        return doPost(url, null);
    }

    public static String doPostJson(String url, String json) throws Exception {
        HttpPost httpPost = null;
        String resultString = "";
        Integer resCode = INIT_CODE;
        CloseableHttpResponse response = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 创建Http Post请求
            httpPost = new HttpPost(url);
            httpPost.setConfig(RequestConfig.custom()
                    .setConnectTimeout(ConfigUtils.CONNECTTIMEOUT)
                    .setConnectionRequestTimeout(ConfigUtils.CONNECTIONREQUESTTIMEOUT)
                    .setSocketTimeout(ConfigUtils.SOCKETTIMEOUT).build());
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            // 判断返回状态是否为200
            resCode = response.getStatusLine().getStatusCode();
            if (resCode == SUCCESS_CODE) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }else {
                log.error(JSON.toJSONString(response.getStatusLine()));
                throw new Exception("request service failed");

            }
        } catch (Exception e) {
            log.error("doPost()", e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error("close()", e);
            }
        }
        return resultString;
    }
}
