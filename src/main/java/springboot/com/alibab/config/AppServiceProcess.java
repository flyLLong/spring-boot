package springboot.com.alibab.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import springboot.com.alibab.annotation.AppService;
import springboot.com.alibab.demo.us.BaseDomainProcess;

@Component
public class AppServiceProcess implements BeanPostProcessor{
	
	private static Map<Long, BaseDomainProcess> domainProcessMap = new HashMap<>();
	private static final Logger log = LoggerFactory.getLogger(AppServiceProcess.class);
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1) throws BeansException {
		Class<?> c = bean.getClass();
		AppService an = c.getAnnotation(AppService.class);
		if(an != null && bean instanceof BaseDomainProcess) {
			domainProcessMap.put(an.domainId(), (BaseDomainProcess) bean);
		}
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {
		return bean;
	}
	
	public static Map<Long, BaseDomainProcess> getDomainProcessMap() {
		return domainProcessMap;
	}
}
