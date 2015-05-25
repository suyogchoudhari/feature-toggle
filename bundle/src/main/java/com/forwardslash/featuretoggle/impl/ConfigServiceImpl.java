package com.forwardslash.featuretoggle.impl;

import java.util.Dictionary;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.forwardslash.featuretoggle.ConfigService;


/**
 * 
 * @author developed by ForwardSlash
 *
 */


@Component(name = "com.forwardslash.featuretoggle.ConfigService", description = "Feature Toggle configuration.", label = "Forward Slash Feature Toggle Configuration", metatype = true, configurationFactory = false, immediate = true)
@Service
@Properties({
        @Property(name = "service.interface", value = "com.forwardslash.featuretoggle.ConfigService", description = "Feature toggle configuarion service"),
        @Property(name = "featurelist", value = "", description = "Please enter comma separated features without space") })
public class ConfigServiceImpl implements ConfigService, ManagedService{

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigServiceImpl.class);
	
	private String featureList;
	
	public String getFeaturesList() {
		LOGGER.debug("ConfigServiceImpl.getFeaturesList()");
		return this.featureList;
	}
	
	public void updated(Dictionary properties) throws ConfigurationException {
		featureList = properties.get("featurelist").toString();
	}
	
}
