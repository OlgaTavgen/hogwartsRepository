//package com.mentoringproject.troubleshooting;
//
//import java.util.concurrent.ConcurrentHashMap;
//import org.slf4j.Logger;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.stereotype.Component;
//
//@Component
//@EnableAspectJAutoProxy
//@Aspect
//public class PerfomanceInterceptor implements MethodInterceptor {
//	
//	 Logger logger = LoggerFactory.getLogger(PerfomanceInterceptor.class.getName());
//	 
//	 private static ConcurrentHashMap<String, MethodStats> methodStats = new ConcurrentHashMap<String, MethodStats>();
//	 private static long statLogFrequency = 10;
//	 private static long methodWarningThreshold = 1000;
//	 
////	 @Pointcut("@annotation(com.mentoringproject.hogwarts.web.RequestMapping)")
//	 @Pointcut("execution(* com.mentoringproject.hogwarts.web.*.*(..))")
//	 public void endpointMethod()
//	 {
//		System.out.println("Start perfomance estimation"); 
//	 }
//
//	 @Around("endpointMethod()")
//	 public Object invoke(MethodInvocation method) throws Throwable
//	 {
//	        long start = System.currentTimeMillis();
//	        try
//	        {
//	            return method.proceed();
//	        }
//	        finally
//	        {
//	            updateStats(method.getMethod().getName(),(System.currentTimeMillis() - start));
//	        }
//	 }
//	 
//	 private void updateStats(String methodName, long elapsedTime)
//	 {
//	        MethodStats stats = methodStats.get(methodName);
//	        if(stats == null) 
//	        {
//	            stats = new MethodStats(methodName);
//	            methodStats.put(methodName,stats);
//	        }
//	        stats.count++;
//	        stats.totalTime += elapsedTime;
//	        if(elapsedTime > stats.maxTime)
//	        {
//	            stats.maxTime = elapsedTime;
//	        }
//	        
//	        if(elapsedTime > methodWarningThreshold)
//	        {
//	            logger.warn("method warning: " + methodName + "(), cnt = " + stats.count + ", lastTime = " + elapsedTime + ", maxTime = " + stats.maxTime);
//	        }
//	        
//	        if(stats.count % statLogFrequency == 0)
//	        {
//	            long avgTime = stats.totalTime / stats.count;
//	            long runningAvg = (stats.totalTime-stats.lastTotalTime) / statLogFrequency;
//	            logger.debug("method: " + methodName + "(), cnt = " + stats.count + ", lastTime = " + elapsedTime + ", avgTime = " + avgTime + ", runningAvg = " + runningAvg + ", maxTime = " + stats.maxTime);
//	            
//	            //reset the last total time
//	            stats.lastTotalTime = stats.totalTime;    
//	        }
//	    }
//	 
//	  class MethodStats 
//	  {
//	        public String methodName;
//	        public long count;
//	        public long totalTime;
//	        public long lastTotalTime;
//	        public long maxTime;
//	        
//	        public MethodStats(String methodName)
//	        {
//	            this.methodName = methodName;
//	        }
//	   }
//	  
//	  @Bean
//	  public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
//	      return new PerformanceMonitorInterceptor(true);
//	  }
//}
