package lastDemo;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5 {

	public static void main(String[] args) {
		
		String algorithmName = "MD5";
		String source = "1234";
		ByteSource salt = ByteSource.Util.bytes("ls");
		int hashIterations = 1024;
		SimpleHash hash = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(hash);
	}
}
