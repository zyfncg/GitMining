package Info;

public class ErrorInfo {
	
	public boolean isWrong;
	
	public String errorMessage;
	
	public ErrorInfo(){
		this.isWrong = false;
		this.errorMessage = null;	
	}
	
	public ErrorInfo(boolean isWrong, String errorMessage) {
		this.isWrong = isWrong;
		this.errorMessage = errorMessage;
	}

}
