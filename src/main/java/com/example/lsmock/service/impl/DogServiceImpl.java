package com.example.lsmock.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.lsmock.dao.DogCfg;
import com.jayway.jsonpath.JsonPath;
import com.example.lsmock.dao.DogToken;
import com.example.lsmock.mapper.DogMapper;
import com.example.lsmock.service.DogService;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DogServiceImpl implements DogService {

    @Value("${dog.token.url}")
    private String DOG_token_url;
    @Value("${dog.token.aspid}")
    private String DOG_aspid;
    @Value("${dog.token.secret}")
    private String DOG_secret;
    @Value("${dog.token.version}")
    private String DOG_version;
    @Value("${dog.send.url}")
    private String DOG_send_url;
    @Value("${dog.token.curcode}")
    private String code;

    @Autowired
    private DogMapper dogMapper;

    @Override
    public void updateDogToken() {
        dogMapper.updateDogToken();
    }

    @Override
    public void deleteDogToken() {
        dogMapper.deleteDogToken();
    }

    @Override
    public DogToken findDogToken() {
        return dogMapper.findDogToken();
    }

    @Override
    public DogCfg findDogCfg() {
        return dogMapper.findDogCfg();
    }

    @Override
    public String accessToken() throws Exception{
        List<BasicNameValuePair> params = new ArrayList<>();
        //AppSigInfo对象参数值
        params.add(new BasicNameValuePair("aspid", DOG_aspid));//需要申请
        params.add(new BasicNameValuePair("secret", DOG_secret));//需要申请
        params.add(new BasicNameValuePair("version", DOG_version));

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(DOG_token_url);
        httpPost.setEntity(new UrlEncodedFormEntity(params));//传参

        CloseableHttpResponse response = httpclient.execute(httpPost);
        String res = EntityUtils.toString(response.getEntity());
        return res;
    }

    @Override
    public String sendMessage(String title, String content, String url, List<String> pins) throws Exception{
        List<BasicNameValuePair> params = new ArrayList<>();
        //鉴权相关参数,，可以先行判断是否有唯一数据筛选出来，如果没有直接响应异常
        DogToken dogToken = findDogToken();
        DogCfg dogCfg = findDogCfg();
        params.add(new BasicNameValuePair("accessToken", dogToken.getAccessToken()));//授权后获得
        params.add(new BasicNameValuePair("aspid", dogToken.getAspid()));//需要申请
        params.add(new BasicNameValuePair("version", DOG_version));
        params.add(new BasicNameValuePair("timestamp", String.valueOf(System.currentTimeMillis())));
        params.add(new BasicNameValuePair("accessid", UUID.randomUUID().toString()));
        //消息相关参数
        JSONObject json = new JSONObject();
        json.put("type", dogCfg.getType());
        json.put("ver", dogCfg.getVer());
        json.put("title", title);//长度限制50
        json.put("content", content);//目前暂不支持换行，长度限制1500
        json.put("noticeId", dogCfg.getNoticeId());// ~加原来的应用标识  如原来的 ump -> ~ump，申请邮件反馈中会给出相应的noticeId
        json.put("toTerminal", dogCfg.getToTerminal());//企业版支持(推所有终端传 7 )
        json.put("app", dogCfg.getApp());//代表发送的用户群体，ee代表国内ERP，泰国th.ee
        json.put("tos", pins);//接收方,一次最大500个
        if(!url.equals(null)&&!url.isEmpty()){
            JSONObject extend = new JSONObject();
            extend.put("url", url);//点击通知可跳转的url
            json.put("extend", extend);
        }
        params.add(new BasicNameValuePair("jsonMsg",json.toJSONString()));
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(DOG_send_url);
        httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));//传参
        CloseableHttpResponse response = httpclient.execute(httpPost);
        String res = EntityUtils.toString(response.getEntity());
        return res;
    }

//    @Scheduled(cron="0 30 */2 * * ?")
    @Override
    public void addDogToken() throws Exception{
        dogMapper.updateDogToken();
        String msg_sign = accessToken();
        DogToken dogToken = new DogToken();
        if(JsonPath.read(msg_sign, "$.code").toString().equals(code)){
            dogToken.setAccessToken(JsonPath.read(msg_sign, "$.accessToken").toString());
            dogToken.setAspid(DOG_aspid);
            dogToken.setIs_delete(0);
        }else{
            dogToken.setAccessToken(JsonPath.read(msg_sign, "$.errmsg").toString());
            dogToken.setAspid(DOG_aspid);
            dogToken.setIs_delete(1);
        }
        dogMapper.addDogToken(dogToken);
        }

}
