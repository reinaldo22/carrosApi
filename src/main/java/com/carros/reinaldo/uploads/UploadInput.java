package com.carros.reinaldo.uploads;

public class UploadInput {

	private String fileName;
	private String base64;
	private String mimeType;

	public UploadInput(String fileName, String base64, String mimeType) {
		
		this.fileName = fileName;
		this.base64 = base64;
		this.mimeType = mimeType;
	}

	public UploadInput() {
		super();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

}
