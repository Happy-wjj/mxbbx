package com.gxwz.medical.util;

import java.util.UUID;


/*自动生成主键*/
public class KeyProvider {

	public static String getPrimaryKey(){
		return UUID.randomUUID().toString();
	}
}
