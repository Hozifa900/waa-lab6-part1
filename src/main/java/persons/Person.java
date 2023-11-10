package persons;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	@Id
	private String id;
	private String name;
	private String message;
	private String chatRoom;

	public String getMessage() {
		return message;
	}

	public void setmessage(String message) {
		this.message = message;
	}

	public Person(String id, String name, String message, String chatRoom) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.chatRoom = chatRoom;
	}

	public Person() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(String chatRoom) {
		this.chatRoom = chatRoom;
	}

}
