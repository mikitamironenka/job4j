<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <entries>
            <xsl:for-each select="account/values">
                <entry>
                    <xsl:attribute name="number">
                        <xsl:value-of select="value"/>
                    </xsl:attribute>
                </entry>
                <xsl:text>&#xa;</xsl:text>
            </xsl:for-each>
        </entries>
    </xsl:template>
</xsl:stylesheet>