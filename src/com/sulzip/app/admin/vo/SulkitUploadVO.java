package com.sulzip.app.admin.vo;

public class SulkitUploadVO {
	private String productNameKor;
	private String productSystemName;
	private String psBridgeVol;
	
	public SulkitUploadVO() {}

	public String getProductNameKor() {
		return productNameKor;
	}

	public void setProductNameKor(String productNameKor) {
		this.productNameKor = productNameKor;
	}

	public String getProductSystemName() {
		return productSystemName;
	}

	public void setProductSystemName(String productSystemName) {
		this.productSystemName = productSystemName;
	}

	public String getPsBridgeVol() {
		return psBridgeVol;
	}

	public void setPsBridgeVol(String psBridgeVol) {
		this.psBridgeVol = psBridgeVol;
	}

	@Override
	public String toString() {
		return "SulkitUploadVO [productNameKor=" + productNameKor + ", productSystemName=" + productSystemName
				+ ", psBridgeVol=" + psBridgeVol + "]";
	}
	
	
}
