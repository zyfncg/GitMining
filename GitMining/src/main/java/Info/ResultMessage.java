package Info;

public class ResultMessage {

	public ErrorInfo errorinfo;
	public Object object;
	
	public ResultMessage(ErrorInfo errorinfo, Object object) {
		this.errorinfo = errorinfo;
		this.object = object;
	}
}
