/**   
* @Title: testClass.java 
* @Package com.luo.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @Company:方正
* @author zhaolei  
* @date 2017年6月30日 上午10:10:28 
* @version V1.0   
*/
package com.luo.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/** 
* @ClassName: testClass 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @Company:方正
* @author zhaolei 
* @version 1.0 2017年6月30日 上午10:10:28 
*/
public class testClass {

	 public static void main(String[] args)    
	    {  
	        new testClass().methodA();  
	        
	    }  
	  
	    private void methodA(){  
	        System.out.println("------进入methodA----------");  
	        methodB();  
	    }  
	  
	    private void methodB(){  
	        System.out.println("------进入methodB----------");  
	        StackTraceElement elements[] = Thread.currentThread().getStackTrace();  
	        for (int i = 0; i < elements.length; i++) {  
	            StackTraceElement stackTraceElement=elements[i];  
	            String className=stackTraceElement.getClassName();  
	            String methodName=stackTraceElement.getMethodName();  
	            String fileName=stackTraceElement.getFileName();  
	            int lineNumber=stackTraceElement.getLineNumber();  
	            System.out.println("StackTraceElement数组下标 i="+i+",fileName="  
	                    +fileName+",className="+className+",methodName="+methodName+",lineNumber="+lineNumber);  
	        }  
	    }  
}
