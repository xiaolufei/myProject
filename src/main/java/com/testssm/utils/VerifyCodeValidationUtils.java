package com.testssm.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 验证码验证工具
 */
public class VerifyCodeValidationUtils {
    public static final String SPLIT_BY = "\\|";
    private static Logger logger = LoggerFactory.getLogger(VerifyCodeValidationUtils.class);
    private static long MAX_VERIFY_CODE_ACTIVE_TIME = 5 * 60 * 1000;
    private static final String VERIFYCODE_KEY = "IMAGE_VERIFY_CODE_KEY";

    /**
     * 检查图形验证码是否正确
     *
     * @param verifyCode
     * @return
     */
    public static boolean checkImageVerifyCode(String verifyCode) {
        return checkImageVerifyCode(verifyCode, false);
    }

    public static boolean checkImageVerifyCode(String verifyCode, boolean nullIsTrue) {
        String sessionImageVerifyCode = (String) SessionUtil.getSessionAttribute(VERIFYCODE_KEY);
        if (StringUtils.isBlank(sessionImageVerifyCode)) {
            return nullIsTrue;
        }
        String[] cachedImageVerifyCode = sessionImageVerifyCode.split(SPLIT_BY);
        if (System.currentTimeMillis() - Long.valueOf(cachedImageVerifyCode[1]) > MAX_VERIFY_CODE_ACTIVE_TIME) {
            logger.debug("图形验证码已超时!");
            return false;
        }
        boolean isTrue = cachedImageVerifyCode[0].equalsIgnoreCase(verifyCode);
        if(logger.isDebugEnabled()) {
            if(!isTrue) {
                logger.debug("Session中存放的图形验证码是:{}, 而输入的验证码是{}。", Arrays.toString(cachedImageVerifyCode), verifyCode);
            }
        }
        return isTrue;
    }

    public static boolean checkImageVerifyCode(String verifyCode, String cacheVerifyCode) {
        if (StringUtils.isBlank(cacheVerifyCode)) {
            return false;
        }
        String[] cachedImageVerifyCode = cacheVerifyCode.split(SPLIT_BY);
        if (System.currentTimeMillis() - Long.valueOf(cachedImageVerifyCode[1]) > MAX_VERIFY_CODE_ACTIVE_TIME) {
            logger.debug("图形验证码已超时!");
            return false;
        }
        boolean isTrue = cachedImageVerifyCode[0].equalsIgnoreCase(verifyCode);
        if(logger.isDebugEnabled()) {
            if(!isTrue) {
                logger.debug("Session中存放的图形验证码是:{}, 而输入的验证码是{}。", Arrays.toString(cachedImageVerifyCode), verifyCode);
            }
        }
        return isTrue;
    }



    public static void createCacheVerifyCode(String verifyCode) {
        String singVerifyCode = verifyCode + "|" + System.currentTimeMillis();
        SessionUtil.setSessionAttribute(VerifyCodeValidationUtils.VERIFYCODE_KEY, singVerifyCode);
        logger.info("本次登录的验证码是:{}",verifyCode);
    }



}
