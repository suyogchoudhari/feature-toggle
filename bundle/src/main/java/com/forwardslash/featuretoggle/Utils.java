package com.forwardslash.featuretoggle;

import java.util.StringTokenizer;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author developed by forwardslash
 *
 * This class have two main purpose. Give ConfigService and API to check if feature exists.
 *   
 */


public class Utils {

	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	
	/*
	 * this API returns ConfigServiceImpl where all configuration related to feature toggle is stored.
	 * Currently this API is only used with this class, however made public if other clients need to access.
	 */
	public static ConfigService getConfigService() throws Exception {
		LOGGER.debug("Utils.getConfigService()");
		ConfigService configService = null;
		BundleContext bundleContext = FrameworkUtil.getBundle(ConfigService.class).getBundleContext();
		configService = (ConfigService) bundleContext.getService(bundleContext.getServiceReference(ConfigService.class.getName()));
		return configService;
	}
	
	/*
	 * check if feature supported.
	 */
	public static boolean isFeatureAvailable(String feature) throws Exception {
		LOGGER.debug("Utils.isFeatureAvailable()");
		boolean flag = false;
		String features = getConfigService().getFeaturesList();
		LOGGER.debug("****** features: " + features);
		
		if (features != null && features.length()>0) {
			// feature list is comma separated string
			StringTokenizer st = new StringTokenizer(features, ",");
			while (st.hasMoreTokens()) {
				if (st.nextToken().trim().equalsIgnoreCase(feature.trim())) {
					return true;
				}
			}
		}
		
		return flag;
	}
}
