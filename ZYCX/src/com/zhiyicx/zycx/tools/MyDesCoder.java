package com.zhiyicx.zycx.tools;

import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 
 * @author Mr . H
 *
 */
public class MyDesCoder
{
	public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
	private static byte[] iv1 =
	{ (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };

	/**

	 * @throws CryptException
	 */
	public static String encode(String key, String data) throws Exception
	{
		return encode(key, data.getBytes());
	}

	/**
	 * @throws CryptException
	 */
	public static String encode(String key, byte[] data) throws Exception
	{
		try
		{
			DESKeySpec dks = new DESKeySpec(key.getBytes());

			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			Key secretKey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
			IvParameterSpec iv = new IvParameterSpec(iv1);
			AlgorithmParameterSpec paramSpec = iv;
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

			byte[] bytes = cipher.doFinal(data);

			// return byte2hex(bytes);
			return new String(Base64.encode(bytes));
		} catch (Exception e)
		{
			throw new Exception(e);
		}
	}


	public static byte[] decode(String key, byte[] data) throws Exception
	{
		try
		{
			SecureRandom sr = new SecureRandom();
			DESKeySpec dks = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			Key secretKey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(ALGORITHM_DES);

			// IvParameterSpec iv = new IvParameterSpec(key.getBytes());
			IvParameterSpec iv = new IvParameterSpec(iv1);
			AlgorithmParameterSpec paramSpec = iv;
			cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
			byte[] result = cipher.doFinal(data);
			return result;
		} catch (Exception e)
		{
			throw new Exception(e);
		}
	}

	/**
	 * @param key
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decodeValue(String key, String data)
	{
		byte[] datas;
		String value = null;
		try
		{

			datas = decode(key, Base64.decode(data));
			value = new String(datas);
		} catch (Exception e)
		{
			e.printStackTrace();
			value = "";
		}
		return value;
	}
}