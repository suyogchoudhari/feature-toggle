package com.forwardslash.featuretoggle.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class FeatureToggleTagHandler extends BaseCQAwareTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8246551163101850404L;
	
	@Override
    public int doEndTag() throws JspException {

        JspWriter out = null;
        return super.doEndTag();
    }

}
