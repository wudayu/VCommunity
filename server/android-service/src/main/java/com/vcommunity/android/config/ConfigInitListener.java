package com.vcommunity.android.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.*;

public final class ConfigInitListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	private Logger logger = LoggerFactory.getLogger(ConfigInitListener.class);

	private final String SYSTEM_PROPERTY_PREFIX = "--";
	private final String SYSTEM_PROPERTY_D_PREFIX = "-D";

	private final String SYSTEM_PROPERTY_SEPARATOR = "=";
	private final String SUN_JAVA_COMMAND = "sun.java.command";

	private final String DEFAULT_SERVICE = "service";
	private final String DEFAULT_SERVICE_KEY = "vcommunity.defservice";

	private static String GLOBAL_PROPERTY_PATH = "/opt/conf/global.properties";

	public static final List<String> services = Lists.newArrayList();

	private static Environment environment = null;;

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		ConfigurableEnvironment env = event.getEnvironment();
		if (Boolean.valueOf(env.getProperty("vcommunity.initproperty"))) {
			Set<String> profiles = Sets.newHashSet();
			String activeProfile = env.getProperty("spring.profiles.active");
			if (StringUtils.isNotBlank(activeProfile)) {
				String[] profilesArray = activeProfile.split(",");
				for (String p : profilesArray) {
					profiles.add(p);
				}
			}
			List<String> services = Lists.newArrayList();
			String service = env.getProperty("vcommunity.services");
			if (StringUtils.isNotBlank(service)) {
				String[] serviceArray = service.split(",");
				for (String s : serviceArray) {
					if (services.contains(s)) {
						services.remove(s);
					}
					services.add(s);
				}
			}
			// default service priority is highest
			String defService = env.getProperty(DEFAULT_SERVICE_KEY);
			if (StringUtils.isBlank(defService)) {
				defService = DEFAULT_SERVICE;
			}
			if (services.contains(defService)) {
				services.remove(defService);
			}
			services.add(defService);

			// add services to final static variable
			ConfigInitListener.services.addAll(services);

			for (String s : services) {
				String sname = "application-" + s;
				try {
					event.getEnvironment()
							.getPropertySources()
							.addFirst(
									new MapPropertySource(sname, property2Map(PropertiesLoaderUtils
											.loadProperties(new ClassPathResource("/" + sname + ".properties")))));
				} catch (IOException e) {
					logger.debug("init custom property error:", e);
				}
				for (String p : profiles) {
					String psname = sname + "-" + p;
					try {
						event.getEnvironment()
								.getPropertySources()
								.addFirst(
										new MapPropertySource(psname, property2Map(PropertiesLoaderUtils
												.loadProperties(new ClassPathResource("/" + psname + ".properties")))));
					} catch (IOException e) {
						logger.debug("init custom property error:", e);
					}
				}
			}
			// add global property
			if (StringUtils.isNotBlank(env.getProperty("vcommunity.property.global"))) {
				GLOBAL_PROPERTY_PATH = env.getProperty("vcommunity.property.global");
			}
			try {
				event.getEnvironment()
						.getPropertySources()
						.addFirst(
								new MapPropertySource("GLOBAL", property2Map(PropertiesLoaderUtils
										.loadProperties(new FileSystemResource(GLOBAL_PROPERTY_PATH)))));
			} catch (IOException e) {
				logger.debug("init global property error:", e);
			}
			event.getEnvironment().getPropertySources()
					.addFirst(new MapPropertySource(SUN_JAVA_COMMAND, getSystemProperties(env.getSystemProperties())));
		}
		environment = env;
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> property2Map(Properties props) {
		Map<String, Object> map = Maps.newHashMap();
		Enumeration<String> enu = (Enumeration<String>) props.propertyNames();
		while (enu.hasMoreElements()) {
			String key = enu.nextElement();
			map.put(key, props.get(key));
		}
		return map;
	}

	private Map<String, Object> getSystemProperties(Map<String, Object> sysps) {
		Map<String, Object> systemPropertie = Maps.newHashMap();
		String sysParams = (String) sysps.get(SUN_JAVA_COMMAND);
		if (StringUtils.isNotBlank(sysParams)) {
			String[] sysParamArray = sysParams.split(" ");
			for (String p : sysParamArray) {
				if (p.trim().startsWith(SYSTEM_PROPERTY_PREFIX) && p.trim().contains(SYSTEM_PROPERTY_SEPARATOR)) {
					String[] par = p.trim().replace(SYSTEM_PROPERTY_PREFIX, "").split(SYSTEM_PROPERTY_SEPARATOR);
					systemPropertie.put(par[0].trim(), par[1].trim());
				} else if (p.trim().startsWith(SYSTEM_PROPERTY_D_PREFIX)
						&& p.trim().contains(SYSTEM_PROPERTY_SEPARATOR)) {
					String[] par = p.trim().replace(SYSTEM_PROPERTY_D_PREFIX, "").split(SYSTEM_PROPERTY_SEPARATOR);
					systemPropertie.put(par[0].trim(), par[1].trim());
				}
			}
		}
		return systemPropertie;
	}

	public static Environment getEnv() {
		return environment;
	}
}
