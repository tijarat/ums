package com.plover.ums.response;

public class ApiResponse 
{
    private String message;
    private int id;

    public ApiResponse(int id,String message) 
    {
        this.message = message;
        this.id = id;
    }

    public int getStatus() {return id;}
    public String getMessage() {return message;}    
}
