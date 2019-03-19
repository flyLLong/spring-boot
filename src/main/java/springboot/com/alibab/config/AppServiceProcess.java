package springboot.com.alibab.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import springboot.com.alibab.annotation.AppService;
import springboot.com.alibab.demo.us.BaseDomainProcess;

public class AppServiceProcess implements BeanPostProcessor{
	
	private static Map<Long, BaseDomainProcess> domainProcessMap = new HashMap<>();
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1) throws BeansException {
		Class<?> c = bean.getClass();
		AppService an = c.getAnnotation(AppService.class);
		if(an != null && bean instanceof BaseDomainProcess) {
			domainProcessMap.put(an.domainId(), (BaseDomainProcess) bean);
		}
		return null;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {
		return null;
	}
	
	public static Map<Long, BaseDomainProcess> getDomainProcessMap() {
		return domainProcessMap;
	}
}
