package com.javaex.vo;

public class FileVo {

	private int no;
	private String ozName;
	private String exName;
	private String saveName;
	private String filePath;
	private long fileSize;
	
	public FileVo() {
		
	}
	
	public FileVo(String ozName, String exName, String saveName, String filePath, long fileSize) {
		this.ozName = ozName;
		this.exName = exName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOzName() {
		return ozName;
	}

	public void setOzName(String ozName) {
		this.ozName = ozName;
	}

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "FileVo [no=" + no + ", ozName=" + ozName + ", exName=" + exName + ", saveName=" + saveName
				+ ", filePath=" + filePath + ", fileSize=" + fileSize + "]";
	}
	
	
	
	
}
