package com.play.bob.schedule;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import com.play.bob.jpush.controller.JpushController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JpushSchedule {

    private static final String MASTER_SECRET = "812c9a8e31292bfabe280044";
    private static final String APP_KEY = "eb1c4bd1b9ce6cdba233b190";

    private Logger logger = LoggerFactory.getLogger(JpushController.class);

    @Scheduled(cron = "0 45 11 * * ?")
    void push() {
        try {
            JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
            // For push, all you need do is to build PushPayload object.
            PushPayload payload = pushAllAlert();
            PushResult pushResult = jpushClient.sendPush(payload);
            logger.info("push success");
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            logger.error("Connection error, should retry later", e);
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            logger.error("Should review the error, and fix the request", e);
            logger.info("HTTP Status: " + e.getStatus());
            logger.info("Error Code: " + e.getErrorCode());
            logger.info("Error Message: " + e.getErrorMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PushPayload pushAllAlert() {
        return PushPayload.alertAll("吃饭时间到了");
    }
}
