package com.vegetables.exception;

import com.vegetables.pojo.Result;
import com.vegetables.util.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/5/14.
 * 统一处理异常
 *      在controller层 throws Exception
 */
@ControllerAdvice
public class ExceptionHandle {

    private final Logger logger = Logger.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        if(e instanceof MyException){
            MyException myException = (MyException)e;
            logger.info(myException.getMessage());
            if(myException.getData()==null||"".equals(myException.getData())){
                myException.setData(myException.getMessage());
            }
            return ResultUtil.requestSuccess(myException.getData(),myException.getMessage(),myException.getCode());
        }
        logger.error(e.getMessage()+"(异常)",e);  //这里必须是logger.error(str1,str2),需要在
        e.printStackTrace();
        return ResultUtil.requestFaild(e.getMessage());
    }

}
