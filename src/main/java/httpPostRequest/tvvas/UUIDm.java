package httpPostRequest.tvvas;

import java.util.UUID;

public class UUIDm {

	public static void main(String[] args) {
		String  ruuid = UUID.randomUUID().toString().replace("-", "");
		System.out.println(ruuid);
	}

}
