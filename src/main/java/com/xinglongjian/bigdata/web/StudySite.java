package com.xinglongjian.bigdata.web;

import java.io.Serializable;

public class StudySite implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String getUrl()
	{
	    return null;
	}
	
	
    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String localName; //localhost
    private java.lang.String contextPath;//WebSA
    private java.lang.String realPath;
    private java.lang.String protocol;
    private java.lang.String localAddr;//127.0.0.1
    private java.lang.String localFront;
    private java.lang.String domainAlias;
    private java.lang.String domainRedirect;
    private int localPort;
    
    /**
     * @return the localPort
     */
    public int getLocalPort()
    {
        return localPort;
    }

    /**
     * @param localPort the localPort to set
     */
    public void setLocalPort(int localPort)
    {
        this.localPort = localPort;
    }

    /**
     * @return the domainAlias
     */
    public java.lang.String getDomainAlias()
    {
        return domainAlias;
    }

    /**
     * @param domainAlias the domainAlias to set
     */
    public void setDomainAlias(java.lang.String domainAlias)
    {
        this.domainAlias = domainAlias;
    }

    /**
     * @return the domainRedirect
     */
    public java.lang.String getDomainRedirect()
    {
        return domainRedirect;
    }

    /**
     * @param domainRedirect the domainRedirect to set
     */
    public void setDomainRedirect(java.lang.String domainRedirect)
    {
        this.domainRedirect = domainRedirect;
    }

    /**
     * @return the localFront
     */
    public java.lang.String getLocalFront()
    {
        return localFront;
    }

    /**
     * @param localFront the localFront to set
     */
    public void setLocalFront(java.lang.String localFront)
    {
        this.localFront = localFront;
    }

    /**
     * @return the realPath
     */
    public java.lang.String getRealPath()
    {
        return realPath;
    }

    /**
     * @param realPath the realPath to set
     */
    public void setRealPath(java.lang.String realPath)
    {
        this.realPath = realPath;
    }

    /**
     * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="site_id"
     */
    public java.lang.Integer getId () {
        return id;
    }

    /**
     * Set the unique identifier of this class
     * @param id the new ID
     */
    public void setId (java.lang.Integer id) {
        this.id = id;
    }

    /**
     * @return the localName
     */
    public java.lang.String getLocalName()
    {
        return localName;
    }

    /**
     * @param localName the localName to set
     */
    public void setLocalName(java.lang.String localName)
    {
        this.localName = localName;
    }

    /**
     * @return the localAddr
     */
    public java.lang.String getLocalAddr()
    {
        return localAddr;
    }

    /**
     * @param localAddr the localAddr to set
     */
    public void setLocalAddr(java.lang.String localAddr)
    {
        this.localAddr = localAddr;
    }

    /**
     * @return the contextPath
     */
    public java.lang.String getContextPath()
    {
        return contextPath;
    }

    /**
     * @param contextPath the contextPath to set
     */
    public void setContextPath(java.lang.String contextPath)
    {
        this.contextPath = contextPath;
    }



    /**
     * Return the value associated with the column: protocol
     */
    public java.lang.String getProtocol () {
        return protocol;
    }

    /**
     * Set the value related to the column: protocol
     * @param protocol the protocol value
     */
    public void setProtocol (java.lang.String protocol) {
        this.protocol = protocol;
    }


}