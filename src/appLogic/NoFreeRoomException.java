package appLogic;

public class NoFreeRoomException extends Exception{
	public NoFreeRoomException(){}
	public NoFreeRoomException(String message){
		super(message);
	}
}
