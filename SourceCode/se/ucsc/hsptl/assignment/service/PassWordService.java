package se.ucsc.hsptl.assignment.service;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import se.ucsc.hsptl.assignment.exception.PassWordServiceException;

/**
 * Created by Indika on 5/7/2017.
 */
public class PassWordService
{
  private static final PassWordService INSTANCE = new PassWordService();
  private Key AESKey;
  private Cipher cipher;

  private PassWordService()
  {
  }

  public static PassWordService getInstance()
  {
    return INSTANCE;
  }

  public boolean validatePassWords(String actual, String entered) throws PassWordServiceException
  {
    return entered.equals(decryptPassWord(getAsByteArray(actual)));
  }

  public String encryptPassWord(String password) throws PassWordServiceException
  {
    Cipher cipher = getCipher();
    try
    {
      cipher.init(Cipher.ENCRYPT_MODE, getAESKey());
      return String.valueOf(cipher.doFinal(password.getBytes()));
    }
    catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e)
    {
      throw new PassWordServiceException("Decryption failed", e);
    }
  }

  public Key getAESKey()
  {
    if (AESKey == null)
    {
      String key = "Encrypt_Password";
      AESKey = new SecretKeySpec(key.getBytes(), "AES");
    }
    return AESKey;
  }

  public Cipher getCipher() throws PassWordServiceException
  {
    if (cipher == null)
    {
      try
      {
        cipher = Cipher.getInstance("AES");
      }
      catch (NoSuchAlgorithmException | NoSuchPaddingException e)
      {
        throw new PassWordServiceException("Cipher text creating failed.", e);
      }
    }
    return cipher;
  }

  private byte[] getAsByteArray(String actual)
  {
    if (!actual.isEmpty())
    {
      return actual.getBytes();
    }
    return new byte[0];
  }

  private String decryptPassWord(byte[] encrypted) throws PassWordServiceException
  {
    Cipher cipher = getCipher();
    try
    {
      cipher.init(Cipher.DECRYPT_MODE, getAESKey());
      return new String(cipher.doFinal(encrypted));
    }
    catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e)
    {
      throw new PassWordServiceException("Decryption failed", e);
    }
  }
}
