package com.efreelearn.eureka;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.config.server.EnableConfigServer;



@SpringBootApplication
@EnableEurekaServer
@EnableConfigServer
@EnableHystrix
@EnableCircuitBreaker
@EnableZuulProxy
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
		
		/*
		 * 2020-06-04 12:08:14.429  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@4218500f: startup date [Thu Jun 04 12:07:13 IST 2020]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@7714e963
2020-06-04 12:08:22.612  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/],methods=[GET]}" onto public java.lang.String org.springframework.cloud.netflix.eureka.server.EurekaController.status(javax.servlet.http.HttpServletRequest,java.util.Map<java.lang.String, java.lang.Object>)
2020-06-04 12:08:22.616  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/lastn],methods=[GET]}" onto public java.lang.String org.springframework.cloud.netflix.eureka.server.EurekaController.lastn(javax.servlet.http.HttpServletRequest,java.util.Map<java.lang.String, java.lang.Object>)
2020-06-04 12:08:22.621  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2020-06-04 12:08:22.622  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2020-06-04 12:08:22.705  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/encrypt],methods=[POST]}" onto public java.lang.String org.springframework.cloud.config.server.encryption.EncryptionController.encrypt(java.lang.String,org.springframework.http.MediaType)
2020-06-04 12:08:22.706  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/encrypt/{name}/{profiles}],methods=[POST]}" onto public java.lang.String org.springframework.cloud.config.server.encryption.EncryptionController.encrypt(java.lang.String,java.lang.String,java.lang.String,org.springframework.http.MediaType)
2020-06-04 12:08:22.707  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/decrypt/{name}/{profiles}],methods=[POST]}" onto public java.lang.String org.springframework.cloud.config.server.encryption.EncryptionController.decrypt(java.lang.String,java.lang.String,java.lang.String,org.springframework.http.MediaType)
2020-06-04 12:08:22.708  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/decrypt],methods=[POST]}" onto public java.lang.String org.springframework.cloud.config.server.encryption.EncryptionController.decrypt(java.lang.String,org.springframework.http.MediaType)
2020-06-04 12:08:22.709  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/encrypt/status],methods=[GET]}" onto public java.util.Map<java.lang.String, java.lang.Object> org.springframework.cloud.config.server.encryption.EncryptionController.status()
2020-06-04 12:08:22.710  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/key],methods=[GET]}" onto public java.lang.String org.springframework.cloud.config.server.encryption.EncryptionController.getPublicKey()
2020-06-04 12:08:22.711  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/key/{name}/{profiles}],methods=[GET]}" onto public java.lang.String org.springframework.cloud.config.server.encryption.EncryptionController.getPublicKey(java.lang.String,java.lang.String)
2020-06-04 12:08:22.791  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{name}-{profiles}.properties],methods=[GET]}" onto public org.springframework.http.ResponseEntity<java.lang.String> org.springframework.cloud.config.server.environment.EnvironmentController.properties(java.lang.String,java.lang.String,boolean) throws java.io.IOException
2020-06-04 12:08:22.800  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{name}/{profiles:.*[^-].*}],methods=[GET]}" onto public org.springframework.cloud.config.environment.Environment org.springframework.cloud.config.server.environment.EnvironmentController.defaultLabel(java.lang.String,java.lang.String)
2020-06-04 12:08:22.803  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{name}-{profiles}.yml || /{name}-{profiles}.yaml],methods=[GET]}" onto public org.springframework.http.ResponseEntity<java.lang.String> org.springframework.cloud.config.server.environment.EnvironmentController.yaml(java.lang.String,java.lang.String,boolean) throws java.lang.Exception
2020-06-04 12:08:22.804  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{name}-{profiles}.json],methods=[GET]}" onto public org.springframework.http.ResponseEntity<java.lang.String> org.springframework.cloud.config.server.environment.EnvironmentController.jsonProperties(java.lang.String,java.lang.String,boolean) throws java.lang.Exception
2020-06-04 12:08:22.806  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{name}/{profiles}/{label:.*}],methods=[GET]}" onto public org.springframework.cloud.config.environment.Environment org.springframework.cloud.config.server.environment.EnvironmentController.labelled(java.lang.String,java.lang.String,java.lang.String)
2020-06-04 12:08:22.807  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{label}/{name}-{profiles}.yml || /{label}/{name}-{profiles}.yaml],methods=[GET]}" onto public org.springframework.http.ResponseEntity<java.lang.String> org.springframework.cloud.config.server.environment.EnvironmentController.labelledYaml(java.lang.String,java.lang.String,java.lang.String,boolean) throws java.lang.Exception
2020-06-04 12:08:22.809  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{label}/{name}-{profiles}.properties],methods=[GET]}" onto public org.springframework.http.ResponseEntity<java.lang.String> org.springframework.cloud.config.server.environment.EnvironmentController.labelledProperties(java.lang.String,java.lang.String,java.lang.String,boolean) throws java.io.IOException
2020-06-04 12:08:22.812  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{label}/{name}-{profiles}.json],methods=[GET]}" onto public org.springframework.http.ResponseEntity<java.lang.String> org.springframework.cloud.config.server.environment.EnvironmentController.labelledJsonProperties(java.lang.String,java.lang.String,java.lang.String,boolean) throws java.lang.Exception
2020-06-04 12:08:22.871  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{name}/{profile}/{label}/**],methods=[GET]}" onto public java.lang.String org.springframework.cloud.config.server.resource.ResourceController.resolve(java.lang.String,java.lang.String,java.lang.String,javax.servlet.http.HttpServletRequest) throws java.io.IOException
2020-06-04 12:08:22.873  INFO 52240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/{name}/{profile}/{label}/**],methods=[GET],produces=[application/octet-stream]}" onto public synchronized byte[] org.springframework.cloud.config.server.resource.ResourceController.binary(java.lang.String,java.lang.String,java.lang.String,javax.servlet.http.HttpServletRequest) throws java.io.IOException
2020-06-04 12:08:23.477  INFO 52240 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
*/
//2020-06-04 12:08:23.478  INFO 52240 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
//2020-06-// 12:08:24.023  INFO 52240 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
		
/*
2020-06-04 12:08:28.412  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/beans || /beans.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.415  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/trace || /trace.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.430  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/pause || /pause.json],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.endpoint.GenericPostableMvcEndpoint.invoke()
2020-06-04 12:08:28.435  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/mappings || /mappings.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.440  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)
2020-06-04 12:08:28.441  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env || /env.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.444  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/dump || /dump.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.447  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/restart || /restart.json],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.context.restart.RestartMvcEndpoint.invoke()
2020-06-04 12:08:28.450  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/configprops || /configprops.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.457  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.459  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/heapdump || /heapdump.json],methods=[GET],produces=[application/octet-stream]}" onto public void org.springframework.boot.actuate.endpoint.mvc.HeapdumpMvcEndpoint.invoke(boolean,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse) throws java.io.IOException,javax.servlet.ServletException
2020-06-04 12:08:28.469  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/loggers/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.get(java.lang.String)
2020-06-04 12:08:28.470  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/loggers/{name:.*}],methods=[POST],consumes=[application/vnd.spring-boot.actuator.v1+json || application/json],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.set(java.lang.String,java.util.Map<java.lang.String, java.lang.String>)
2020-06-04 12:08:28.472  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/loggers || /loggers.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.478  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/refresh || /refresh.json],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.endpoint.GenericPostableMvcEndpoint.invoke()
2020-06-04 12:08:28.536  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)
2020-06-04 12:08:28.537  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics || /metrics.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.539  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/health || /health.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(javax.servlet.http.HttpServletRequest,java.security.Principal)
2020-06-04 12:08:28.542  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/info || /info.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.545  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/resume || /resume.json],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.endpoint.GenericPostableMvcEndpoint.invoke()
2020-06-04 12:08:28.546  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/hystrix.stream/**]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.cloud.netflix.endpoint.ServletWrappingEndpoint.handle(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse) throws java.lang.Exception
2020-06-04 12:08:28.549  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/features || /features.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:28.551  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.context.environment.EnvironmentManagerMvcEndpoint.value(java.util.Map<java.lang.String, java.lang.String>)
2020-06-04 12:08:28.552  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env/reset],methods=[POST]}" onto public java.util.Map<java.lang.String, java.lang.Object> org.springframework.cloud.context.environment.EnvironmentManagerMvcEndpoint.reset()
2020-06-04 12:08:28.555  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/auditevents || /auditevents.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.boot.actuate.endpoint.mvc.AuditEventsMvcEndpoint.findByPrincipalAndAfterAndType(java.lang.String,java.util.Date,java.lang.String)
2020-06-04 12:08:28.557  INFO 52240 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/archaius || /archaius.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
2020-06-04 12:08:30.289  INFO 52240 --- [           main] o.s.ui.freemarker.SpringTemplateLoader   : SpringTemplateLoader for FreeMarker: using resource loader [org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@4218500f: startup date [Thu Jun 04 12:07:13 IST 2020]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@7714e963] and template loader path [classpath:/templates/]
2020-06-04 12:08:30.292  INFO 52240 --- [           main] o.s.w.s.v.f.FreeMarkerConfigurer         : ClassTemplateLoader for Spring macros added to FreeMarker configuration
2020-06-04 12:08:32.431  WARN 52240 --- [           main] o.s.c.n.a.ArchaiusAutoConfiguration      : No spring.application.name found, defaulting to 'application'
2020-06-04 12:08:32.441  WARN 52240 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
2020-06-04 12:08:32.442  INFO 52240 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
2020-06-04 12:08:33.082  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2020-06-04 12:08:33.114  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'refreshScope' has been autodetected for JMX exposure
2020-06-04 12:08:33.117  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'environmentManager' has been autodetected for JMX exposure
2020-06-04 12:08:33.122  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'configurationPropertiesRebinder' has been autodetected for JMX exposure
2020-06-04 12:08:33.126  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'refreshEndpoint' has been autodetected for JMX exposure
2020-06-04 12:08:33.128  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'restartEndpoint' has been autodetected for JMX exposure
2020-06-04 12:08:33.145  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'environmentManager': registering with JMX server as MBean [org.springframework.cloud.context.environment:name=environmentManager,type=EnvironmentManager]
2020-06-04 12:08:33.295  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'restartEndpoint': registering with JMX server as MBean [org.springframework.cloud.context.restart:name=restartEndpoint,type=RestartEndpoint]
2020-06-04 12:08:33.345  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'refreshScope': registering with JMX server as MBean [org.springframework.cloud.context.scope.refresh:name=refreshScope,type=RefreshScope]
2020-06-04 12:08:33.480  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'configurationPropertiesRebinder': registering with JMX server as MBean [org.springframework.cloud.context.properties:name=configurationPropertiesRebinder,context=4218500f,type=ConfigurationPropertiesRebinder]
2020-06-04 12:08:33.513  INFO 52240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'refreshEndpoint': registering with JMX server as MBean [org.springframework.cloud.endpoint:name=refreshEndpoint,type=RefreshEndpoint]
2020-06-04 12:08:34.521  INFO 52240 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 0
2020-06-04 12:08:34.527  INFO 52240 --- [           main] c.n.e.EurekaDiscoveryClientConfiguration : Registering application unknown with eureka with status UP
2020-06-04 12:08:34.527  INFO 52240 --- [      Thread-11] o.s.c.n.e.server.EurekaServerBootstrap   : Setting the eureka configuration..
2020-06-04 12:08:34.529  INFO 52240 --- [      Thread-11] o.s.c.n.e.server.EurekaServerBootstrap   : Eureka data center value eureka.datacenter is not set, defaulting to default
2020-06-04 12:08:34.531  INFO 52240 --- [      Thread-11] o.s.c.n.e.server.EurekaServerBootstrap   : Eureka environment value eureka.environment is not set, defaulting to test
2020-06-04 12:08:34.667  INFO 52240 --- [      Thread-11] o.s.c.n.e.server.EurekaServerBootstrap   : isAws returned false
2020-06-04 12:08:34.670  INFO 52240 --- [      Thread-11] o.s.c.n.e.server.EurekaServerBootstrap   : Initialized server context
2020-06-04 12:08:34.671  INFO 52240 --- [      Thread-11] c.n.e.r.PeerAwareInstanceRegistryImpl    : Got 1 instances from neighboring DS node
2020-06-04 12:08:34.672  INFO 52240 --- [      Thread-11] c.n.e.r.PeerAwareInstanceRegistryImpl    : Renew threshold is: 1
2020-06-04 12:08:34.675  INFO 52240 --- [      Thread-11] c.n.e.r.PeerAwareInstanceRegistryImpl    : Changing status to UP
2020-06-04 12:08:34.693  INFO 52240 --- [      Thread-11] e.s.EurekaServerInitializerConfiguration : Started Eureka Server
2020-06-04 12:08:34.888  INFO 52240 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
2020-06-04 12:08:34.955  INFO 52240 --- [           main] ration$HystrixMetricsPollerConfiguration : Starting poller
2020-06-04 12:08:35.742  INFO 52240 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8761 (http)
2020-06-04 12:08:35.746  INFO 52240 --- [           main] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 8761
2020-06-04 12:08:35.757  INFO 52240 --- [           main] com.efreelearn.eureka.EurekaApplication  : Started EurekaApplication in 95.237 seconds (JVM running for 97.618)

		 */
	}

}
