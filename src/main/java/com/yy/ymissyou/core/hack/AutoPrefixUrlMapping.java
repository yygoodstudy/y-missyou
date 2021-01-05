package com.yy.ymissyou.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 自动为我们的控制器的路由地址添加上/v1/packageName/...的路由，
 * 可能我们之前的访问路径是这样的：localhost:8099/exception/test,现在需要http://localhost:8099/v1/exception/test；
 * 才能访问。
 * 
 * @author Admin
 *
 */
public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

	@Value("${miss-you.api.package}")
	private String apiPackagePath;
	@Value("${miss-you.api.package}")
	private String username;

	@Override
	protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
		RequestMappingInfo mappingForMethod = super.getMappingForMethod(method, handlerType);
		String packageName = this.getPrefix(handlerType);
		if (mappingForMethod != null) {
			// 生成新的RequestMappingInfo：这个RequestMappingInfo已经被我们修改了，我们将它默认的路由地址自动添加前缀/v1.
			RequestMappingInfo combine = RequestMappingInfo.paths(packageName).build().combine(mappingForMethod);
			System.out.println("combine="+combine);
			return RequestMappingInfo.paths(packageName).build().combine(mappingForMethod);
		}
		return mappingForMethod;
	}

	private String getPrefix(Class<?> handlerType) {
		String packageName = handlerType.getPackage().getName(); // = yy.ymissyou.api.v1
		String dotPathString = packageName.replaceAll(this.apiPackagePath, ""); //this.apiPackagePath = yy.ymissyou.api
		return dotPathString.replace(".", "/"); // return "/v1";
	}

}
