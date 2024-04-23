package com.tugonn.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chhavi Priya Tanwar
 */
public class HTTPResponse {

    private Object data;
    private String message;
    private short status;

    public HTTPResponse() {
    }

    public Map<String,Object> getHttpResponse(Object data, String message, short status){
        Map<String,Object> map = new HashMap<>();
        map.put("data",data);
        map.put("message",message);
        map.put("status",status);
        return map;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HTTPResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
