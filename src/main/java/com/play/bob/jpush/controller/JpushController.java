package com.play.bob.jpush.controller;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import com.play.bob.base.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author baobo.peng
 */
@Controller
@RequestMapping("/jpush")
public class JpushController {

    private static final String MASTER_SECRET = "812c9a8e31292bfabe280044";
    private static final String APP_KEY = "eb1c4bd1b9ce6cdba233b190";

    private Logger logger = LoggerFactory.getLogger(JpushController.class);

    @RequestMapping("/push")
    @ResponseBody
    BaseResult<Object> push(HttpServletRequest request) {
        BaseResult<Object> result = new BaseResult<>();
        try {
            JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
            // For push, all you need do is to build PushPayload object.
            String pushMsg = request.getParameter("msg");
            PushPayload payload = pushAllAlert(pushMsg);
            PushResult pushResult = jpushClient.sendPush(payload);
            result.setCode(200);
            result.setMsg("success");
            result.setData(pushResult);
            logger.info("push success");
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            logger.error("Connection error, should retry later", e);
            result.setCode(300);
            result.setMsg("failure");
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            logger.error("Should review the error, and fix the request", e);
            logger.info("HTTP Status: " + e.getStatus());
            logger.info("Error Code: " + e.getErrorCode());
            logger.info("Error Message: " + e.getErrorMessage());
            result.setCode(300);
            result.setMsg("failure");
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(300);
            result.setMsg("failure");
        }
        return result;
    }

    private PushPayload pushAllAlert(String pushMsg) {
        if (StringUtils.isEmpty(pushMsg)) {
            pushMsg = "Hello Everyone";
        }
        return PushPayload.alertAll(pushMsg);
    }
}
