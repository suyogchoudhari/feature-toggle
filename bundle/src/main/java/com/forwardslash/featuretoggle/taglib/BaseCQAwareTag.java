package com.forwardslash.featuretoggle.taglib;

import javax.jcr.Node;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.inherit.InheritanceValueMap;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMMode;
import com.day.cq.wcm.api.components.Component;
import com.day.cq.wcm.api.components.ComponentContext;
import com.day.cq.wcm.api.components.EditContext;
import com.day.cq.wcm.api.designer.Design;
import com.day.cq.wcm.api.designer.Designer;
import com.day.cq.wcm.api.designer.Style;

/**
 * Class that has base functionality needed to access CQ features
 * 
 * @extends TagSupport
 * 
 */
public class BaseCQAwareTag extends TagSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3823679818581861899L;

	private static final Logger LOGGER = LoggerFactory
            .getLogger(BaseCQAwareTag.class);

    protected static final String HTML = ".html";

    private Node currentNode = null;
    private SlingScriptHelper sling = null;
    private SlingHttpServletRequest slingRequest = null;
    private Page currentPage = null;

    private SlingHttpServletResponse slingResponse = null;
    private SlingBindings bindings = null;

    private Resource resource = null;
    private ResourceResolver resourceResolver = null;
    private Logger log = null;
    private ComponentContext componentContext = null;
    private EditContext editContext = null;
    private ValueMap properties = null;
    private PageManager pageManager = null;
    private Page resourcePage = null;

    private InheritanceValueMap pageProperties = null;

    private Component component = null;
    private Designer designer = null;
    private Design currentDesign = null;
    private Design resourceDesign = null;
    private Style currentStyle = null;

    @Override
    /**
     * Set variables to be accessible via Page Context
     * @param pageContext
     */
    public void setPageContext(PageContext pageContext) {
        LOGGER.debug("Setting page context.");
        super.setPageContext(pageContext);
        currentNode = (Node) pageContext.findAttribute("currentNode");
        sling = (SlingScriptHelper) pageContext.findAttribute("sling");
        slingRequest = (SlingHttpServletRequest) pageContext
                .findAttribute("slingRequest");
        slingResponse = (SlingHttpServletResponse) pageContext
                .findAttribute("slingResponse");
        resource = (Resource) pageContext.findAttribute("resource");
        resourceResolver = (ResourceResolver) pageContext
                .findAttribute("resourceResolver");
        log = (Logger) pageContext.findAttribute("	");
        bindings = (SlingBindings) pageContext.findAttribute("bindings");
        componentContext = (ComponentContext) pageContext
                .findAttribute("componentContext");
        editContext = (EditContext) pageContext.findAttribute("editContext");
        properties = (ValueMap) pageContext.findAttribute("properties");
        pageManager = (PageManager) pageContext.findAttribute("pageManager");
        currentPage = (Page) pageContext.findAttribute("currentPage");
        resourcePage = (Page) pageContext.findAttribute("resourcePage");
        pageProperties = (InheritanceValueMap) pageContext
                .findAttribute("pageProperties");
        component = (Component) pageContext.findAttribute("component");
        designer = (Designer) pageContext.findAttribute("designer");
        currentDesign = (Design) pageContext.findAttribute("currentDesign");
        resourceDesign = (Design) pageContext.findAttribute("resourceDesign");
        currentStyle = (Style) pageContext.findAttribute("currentStyle");
    }

    protected boolean isAuthoringMode() {
        return WCMMode.fromRequest(pageContext.getRequest()).equals(
                WCMMode.EDIT)
                || WCMMode.fromRequest(pageContext.getRequest()).equals(
                        WCMMode.DESIGN);
    }

    protected String appendHtmlSelectorIfResource(String imgurl) {
        Resource linkResource = getSlingRequest().getResourceResolver()
                .getResource(imgurl);

        if (linkResource != null) {
            imgurl = imgurl + HTML;
        }
        return imgurl;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public SlingScriptHelper getSling() {
        return sling;
    }

    public void setSling(SlingScriptHelper sling) {
        this.sling = sling;
    }

    public SlingHttpServletRequest getSlingRequest() {
        return slingRequest;
    }

    public void setSlingRequest(SlingHttpServletRequest slingRequest) {
        this.slingRequest = slingRequest;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    public SlingHttpServletResponse getSlingResponse() {
        return slingResponse;
    }

    public void setSlingResponse(SlingHttpServletResponse slingResponse) {
        this.slingResponse = slingResponse;
    }

    public SlingBindings getBindings() {
        return bindings;
    }

    public void setBindings(SlingBindings bindings) {
        this.bindings = bindings;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public ResourceResolver getResourceResolver() {
        return resourceResolver;
    }

    public void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    public ComponentContext getComponentContext() {
        return componentContext;
    }

    public void setComponentContext(ComponentContext componentContext) {
        this.componentContext = componentContext;
    }

    public EditContext getEditContext() {
        return editContext;
    }

    public void setEditContext(EditContext editContext) {
        this.editContext = editContext;
    }

    public ValueMap getProperties() {
        return properties;
    }

    public void setProperties(ValueMap properties) {
        this.properties = properties;
    }

    public PageManager getPageManager() {
        return pageManager;
    }

    public void setPageManager(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    public Page getResourcePage() {
        return resourcePage;
    }

    public InheritanceValueMap getPageProperties() {
        return pageProperties;
    }

    public void setResourcePage(Page resourcePage) {
        this.resourcePage = resourcePage;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public Design getCurrentDesign() {
        return currentDesign;
    }

    public void setCurrentDesign(Design currentDesign) {
        this.currentDesign = currentDesign;
    }

    public Design getResourceDesign() {
        return resourceDesign;
    }

    public void setResourceDesign(Design resourceDesign) {
        this.resourceDesign = resourceDesign;
    }

    public Style getCurrentStyle() {
        return currentStyle;
    }

    public void setCurrentStyle(Style currentStyle) {
        this.currentStyle = currentStyle;
    }
}
