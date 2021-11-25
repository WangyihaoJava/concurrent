package com.example.concurrent.exception;

import java.util.Map;

/**
 * @author wangyihao
 * @ClassName ResourceNotFoundException
 * @date 2020/12/18 14:40
 * @Description
 */
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }
}
