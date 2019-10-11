package org.apz.curso.media;

public interface Constants {
	
	
	 public enum IdFormat {
	        WEB,
	        FX;
	 }
	 
	 public enum MediaOrder {
		    DATE_ASC,
		    DATE_DESC,
		    TITLE_ASC,
		    TITLE_DESC;
	 }
	 
	 public enum MediaType {
	        OTHER(""),
	        FLASH_VIDEO(".*flv$|"),
	        OGV_VIDEO(".*ogv$|"),
	        MP4_VIDEO(".*mpg4$|.*mp4$|.*m4v$|"),
	        IMAGE(".*jpg$|.*jpeg$|.*png$|.*gif$|");
		 
		private String regexExtension;
		
		MediaType(String regexExtension) {
				this.regexExtension = regexExtension;
		}
		 
		public String getRegexExtension() {
			return regexExtension;
		}
	}
	
}
