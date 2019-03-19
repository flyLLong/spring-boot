package springboot.com.alibab.demo.us;

import springboot.com.alibab.annotation.AppService;

@AppService(domainId = 1L, domainName = CallDomainProcess.DOMAIN_NAME)
public class CallDomainProcess extends BaseDomainProcess{
	
	public static final String DOMAIN_NAME = "call";
	
	@Override
	protected String getDomainName() {
		return DOMAIN_NAME;
	}
	
	
}
