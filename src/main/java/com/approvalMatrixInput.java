package com;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class approvalMatrixInput implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.String facilityProduct;
	private Double amount;
	private java.lang.Integer securityCoverage;

	public approvalMatrixInput() {
	}

	public java.lang.String getFacilityProduct() {
		return this.facilityProduct;
	}

	public void setFacilityProduct(java.lang.String facilityProduct) {
		this.facilityProduct = facilityProduct;
	}

	public java.lang.Integer getSecurityCoverage() {
		return this.securityCoverage;
	}

	public void setSecurityCoverage(java.lang.Integer securityCoverage) {
		this.securityCoverage = securityCoverage;
	}

	public java.lang.Double getAmount() {
		return this.amount;
	}

	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	}

	public approvalMatrixInput(java.lang.String facilityProduct,
			java.lang.Double amount, java.lang.Integer securityCoverage) {
		this.facilityProduct = facilityProduct;
		this.amount = amount;
		this.securityCoverage = securityCoverage;
	}

}