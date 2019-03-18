package springboot.com.alibab.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAop {
	
	private static final Logger log = LoggerFactory.getLogger(LogAop.class);
	
	@Pointcut("execution(public * springboot.com.alibab.controller.*.*(..))")
	public void executeService() {
		
	}
	
	@Before("executeService()")
	public void beforeExecute(JoinPoint jp) {
		log.info("before execute");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		log.info("URL : {}", request.getRequestURL().toString());
		log.info("HTTP_METHOD : {}", request.getMethod());
		log.info("IP : {}", request.getRemoteAddr());
		log.info("CLASS_METHOD : {}", jp.getSignature().getDeclaringTypeName() + "." + 
				jp.getSignature().getName());
		log.info("ARGS : {}", jp.getArgs());
	}
	
	@After("executeService()")
	public void afterExecute(JoinPoint jp) {
		log.info("after execute");
	}
	
	@Around("executeService()")
	public Object aroundExecute(ProceedingJoinPoint jp) {
		log.info("around 1 execute");
		Object result = null;
		try {
			result = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("around 2 execute");
		return result;
	}
	
	@AfterReturning("executeService()")
	public void returningExecute(JoinPoint jp) {
		log.info("@AfterReturning execute");
	}
	
}
