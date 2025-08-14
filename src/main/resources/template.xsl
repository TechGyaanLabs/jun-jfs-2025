<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
    
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm" margin-top="1cm" margin-bottom="1cm" margin-left="1cm" margin-right="1cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="18pt" font-weight="bold" text-align="center" margin-bottom="20pt">
                        Players List
                    </fo:block>
                    
                    <fo:table table-layout="fixed" width="100%" border-collapse="collapse">
                        <fo:table-column column-width="25%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="15%"/>
                        
                        <!-- Header row -->
                        <fo:table-header>
                            <fo:table-row background-color="#f0f0f0">
                                <fo:table-cell border="1pt solid black" padding="5pt">
                                    <fo:block font-weight="bold" text-align="center">Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black" padding="5pt">
                                    <fo:block font-weight="bold" text-align="center">Role</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black" padding="5pt">
                                    <fo:block font-weight="bold" text-align="center">Country</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black" padding="5pt">
                                    <fo:block font-weight="bold" text-align="center">Team</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black" padding="5pt">
                                    <fo:block font-weight="bold" text-align="center">Price</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        
                        <!-- Data rows -->
                        <fo:table-body>
                            <xsl:for-each select="players/player">
                                <fo:table-row>
                                    <fo:table-cell border="1pt solid black" padding="5pt">
                                        <fo:block text-align="left"><xsl:value-of select="name"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black" padding="5pt">
                                        <fo:block text-align="left"><xsl:value-of select="role"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black" padding="5pt">
                                        <fo:block text-align="left"><xsl:value-of select="country"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black" padding="5pt">
                                        <fo:block text-align="left"><xsl:value-of select="team"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black" padding="5pt">
                                        <fo:block text-align="right"><xsl:value-of select="price"/></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet> 