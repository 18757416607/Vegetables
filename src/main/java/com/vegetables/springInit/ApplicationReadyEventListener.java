package com.vegetables.springInit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by Administrator on 2018/6/22.
 */
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    Logger logger = Logger.getLogger(ApplicationReadyEventListener.class);

    @Autowired
    private SpringApplicationContextHolder springApplicationContextHolder;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        /*System.out.println("--------------------------------------------------");
        System.out.println("------spring容器初始化时调用获取微信token线程-------");
        System.out.println("--------------------------------------------------");
        AccessToken accessToken = null;
        try {
            accessToken = Constant.accessToken = RequestWx.getAccessToken();
            System.out.println("\n\n【获取微信token】:"+accessToken.getAccess_token()+"\n\n");
            AutologonMapper autologonMapper = (AutologonMapper)springApplicationContextHolder.getSpringBean("autologonMapper");
            int insertTokenCount = autologonMapper.insertBaseWxAccessToken(accessToken.getAccess_token());
            if(insertTokenCount>0){
                logger.info("微信获取   Access_Token  线程-->同步PHP接口Token成功");
            }else{
                logger.info("微信获取   Access_Token  线程-->同步PHP接口Token失败");
            }

            Config config = (Config) springApplicationContextHolder.getSpringBean("config");
            YouZanYunToken youZanYunToken = null;
            for(int i = 0;i<5;i++){
                youZanYunToken = Constant.youzanyun_accessToken = YouZanYunUtil.getYouZanYunToken(config);
                logger.info("\n\n第"+(i+1)+"次获取【获取有赞云token】:"+youZanYunToken.getAccess_token()+"\n\n");
                if(youZanYunToken!=null&&youZanYunToken.getAccess_token()!=null||!"".equals(youZanYunToken.getAccess_token())){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        /*try{
            Config config = (Config) springApplicationContextHolder.getSpringBean("config");
            YouZanYunToken youZanYunToken = null;
            for(int i = 0;i<5;i++){
                youZanYunToken = Constant.youzanyun_accessToken = YouZanYunUtil.getYouZanYunToken(config);
                logger.info("\n\n第"+(i+1)+"次获取【获取有赞云token】:"+youZanYunToken.getAccess_token()+"\n\n");
                if(youZanYunToken!=null&&youZanYunToken.getAccess_token()!=null||!"".equals(youZanYunToken.getAccess_token())){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

        logger.info("-------------------ApplicationReadyEventListener----------------");
    }
}
