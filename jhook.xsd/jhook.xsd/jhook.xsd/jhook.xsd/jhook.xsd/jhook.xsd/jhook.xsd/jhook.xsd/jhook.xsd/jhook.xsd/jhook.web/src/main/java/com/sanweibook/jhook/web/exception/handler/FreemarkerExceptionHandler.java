package com.sanweibook.jhook.web.exception.handler;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by twg on 17/3/14.
 */
public class FreemarkerExceptionHandler implements TemplateExceptionHandler {
    @Override
    public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {
        //
        try {
            out.append("自定义HTML页面");
            out.flush();
        }catch (Exception e){

        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
