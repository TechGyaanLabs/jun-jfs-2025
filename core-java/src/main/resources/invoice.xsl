<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/invoice">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4"
                                       page-height="29.7cm" page-width="21cm" margin="2cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">

                    <!-- Title -->
                    <fo:block font-size="16pt" font-weight="bold" space-after="10pt">
                        Invoice - <xsl:value-of select="invoiceId"/>
                    </fo:block>

                    <!-- Invoice Info -->
                    <fo:block>Date: <xsl:value-of select="invoiceDate"/></fo:block>
                    <fo:block>Due Date: <xsl:value-of select="dueDate"/></fo:block>
                    <fo:block>Status: <xsl:value-of select="status"/></fo:block>

                    <!-- Customer Info -->
                    <fo:block space-before="10pt" font-weight="bold">Customer Info:</fo:block>
                    <fo:block>Name: <xsl:value-of select="recipient/contactPerson"/></fo:block>
                    <fo:block>Email: <xsl:value-of select="recipient/email"/></fo:block>
                    <fo:block>Phone: <xsl:value-of select="recipient/phone"/></fo:block>
                    <fo:block>Address: <xsl:value-of select="recipient/address"/></fo:block>

                    <!-- Items Table -->
                    <fo:block space-before="15pt" font-weight="bold">Items:</fo:block>
                    <fo:table table-layout="fixed" width="100%" border="solid 1px black">

                        <!-- Table Header -->
                        <fo:table-header>
                            <fo:table-row background-color="#CCCCCC">
                                <fo:table-cell><fo:block>ID</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Name</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Qty</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Unit Price</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block>Total</fo:block></fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>

                        <!-- Table Body -->
                        <fo:table-body>
                            <xsl:for-each select="items">
                                <fo:table-row>
                                    <fo:table-cell><fo:block><xsl:value-of select="position()"/></fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block><xsl:value-of select="description"/></fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block><xsl:value-of select="quantity"/></fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block><xsl:value-of select="unitPrice"/></fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block><xsl:value-of select="total"/></fo:block></fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>

                    </fo:table>

                    <!-- Totals -->
                    <fo:block space-before="10pt">Subtotal: ₹<xsl:value-of select="subtotal"/></fo:block>
                                <fo:block>Tax Amount: ₹<xsl:value-of select="taxTotal"/></fo:block>
                    <fo:block font-weight="bold">Total Amount: ₹<xsl:value-of select="grandTotal"/></fo:block>

                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
