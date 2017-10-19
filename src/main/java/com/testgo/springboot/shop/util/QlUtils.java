package com.testgo.springboot.shop.util;

import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianqiao on 16/8/5.
 */

@Component
public class QlUtils implements ApplicationContextAware {

    public Object executeScript(String script){

        IExpressContext<String, Object> context = new SpringContext(new HashMap<String,Object>(), this.applicationContext);
        try {
            ExpressRunner qlRunner = new ExpressRunner();
            Object result = qlRunner.execute(script, context, null, true, false);
            return result;
        } catch (Exception e) {
            return ExceptionUtil.getStackTrace(e);
        }
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

class SpringContext extends HashMap<String,Object> implements IExpressContext<String,Object>{

    private ApplicationContext applicationContext;

    public SpringContext(Map<String,Object> aProperties, ApplicationContext aContext){
        super(aProperties);
        this.applicationContext = aContext;
    }

    public Object get(Object name) {
        Object result = null;
        result = super.get(name);
        try{
            if (result == null &&this.applicationContext != null && this.applicationContext.containsBean((String)name)) {
                result = this.applicationContext.getBean((String)name);
            }
        }catch(Exception  e){
            throw new RuntimeException(e);
        }
        return result;
    }

    public Object  put(String name, Object object) {
        return  super.put(name,object);
    }
}

