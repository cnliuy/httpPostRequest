package httpPostRequest;

import java.util.UUID;

public class UUIDCreate {
	//´´½¨uuid×Ö·û´®
	public static void main(String[] args) {
		  String uuid = UUID.randomUUID().toString(); 
		  String uuids = uuid.substring(0,8)+uuid.substring(9,13)+uuid.substring(14,18)+uuid.substring(19,23)+uuid.substring(24); 
	      System.out.println(uuids);
	}
}
