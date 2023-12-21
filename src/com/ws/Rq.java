package com.ws;

import java.util.HashMap;
import java.util.Map;

public class Rq {
	private String actionCode;
	Map<String, String> params;

	public Rq(String cmd) {
		// parsing
		String[] cmdBits = cmd.split("\\?", 2);
		actionCode = cmdBits[0];
		params = new HashMap<>();

		if (cmdBits.length == 1) {
			return;
		}
		
		if (cmdBits[1].contains("&")) {
			String[] paramBits = cmdBits[1].split("&");

			for (String paramStr : paramBits) {
				String[] paramStrBits = paramStr.split("=", 2);
				if (paramBits.length == 1) {
					continue;
				}

				String key = paramStrBits[0];
				String value = paramStrBits[1];
				params.put(key, value);
			}
		}
		
		String paramBits = cmdBits[1];
		String[] paramStrBits = paramBits.split("=", 2);
		String key = paramStrBits[0];
		String value = paramStrBits[1];
		
		params.put(key, value);

	}

	public String getActionCode() {
		return actionCode;
	}

	public String getParam(String name) {
		return params.get(name);
	}

	public int getIntParam() {
		return Integer.parseInt(getParam("id"));
	}

}
