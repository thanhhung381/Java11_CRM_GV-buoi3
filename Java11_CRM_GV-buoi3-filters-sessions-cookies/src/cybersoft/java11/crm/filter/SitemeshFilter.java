package cybersoft.java11.crm.filter;

import javax.servlet.annotation.WebFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@WebFilter(displayName = "sitemesh", urlPatterns = "UrlConst.ROOT")
public class SitemeshFilter extends SiteMeshFilter{

}
