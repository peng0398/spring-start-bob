package com.play.bob.global.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baobo.peng
 */
@Controller
public class GlobalErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public Exception error() throws Exception {
        throw new Exception("请求异常");
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
