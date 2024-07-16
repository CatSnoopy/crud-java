package com.practica.crudoriginal.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHttpApi {

    private boolean processNegOK;

    private boolean processServOK;

    public static String message;

    private Object data;


    public static Map<String, Object> responseHttpFind(String result, List<?> data, HttpStatus codeMessage){

        Map<String,Object> response = new HashMap<>();

        response.put("date",new Date());
        response.put("code",codeMessage.value());
        response.put("message",result);

        if (!data.isEmpty()) {
            response.put("data", new ArrayList<>());

            data.forEach(data1 -> {
                if (data1!= null) {
                    System.out.println(data1);
                    ((List<Object>) response.get("data")).add(data1);
                } else {

                    ((List<Object>) response.get("data")).add("[]");

                }
            });

        }else{
            response.put("data",new ArrayList<>());
        }

        return response;
    }


    //Post
    public static Map<String, Object> responseHttpPost(String result, HttpStatus codeMessage){

        Map<String,Object> response = new HashMap<>();

        response.put("date",new Date());
        response.put("code",codeMessage.value());
        response.put("message",result);
        return response;
    }

    //Put
    public static Map<String, Object> responseHttpPut(String result, HttpStatus codeMessage){

        Map<String,Object> response = new HashMap<>();

        response.put("date",new Date());
        response.put("code",codeMessage.value());
        response.put("message",result);

        return response;
    }

    //Delete
    public static Map<String, Object> responseHttpDelete(String result, HttpStatus codeMessage){
        Map<String,Object> response = new HashMap<>();
        response.put("date",new Date());
        response.put("code",codeMessage.value());
        response.put("message",result);
        return response;
    }

    //Error
    public static Map<String,Object> responseHttpError(String result,HttpStatus codeMessage,String data){
        Map<String,Object> response = new HashMap<>();

        response.put("date",new Date());
        response.put("code",codeMessage.value());
        response.put("message",result);
        response.put("data",data);

        return response;
    }
}
