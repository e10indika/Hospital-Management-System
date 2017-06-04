package se.ucsc.hsptl.assignment.data;

/**
 * Created by Indika on 4/29/2017.
 */
public class ContactData
{
  private String mobilePhone;
  private String homePhone;
  private String officePhone;
  private String[] address;
  private String email;

  public ContactData(String mobilePhone, String homePhone, String officePhone, String[] address, String email)
  {
    this.mobilePhone = mobilePhone;
    this.homePhone = homePhone;
    this.officePhone = officePhone;
    this.address = address;
    this.email = email;
  }

  public String getMobilePhone()
  {
    return mobilePhone;
  }

  public ContactData setMobilePhone(String mobilePhone)
  {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public String getHomePhone()
  {
    return homePhone;
  }

  public ContactData setHomePhone(String homePhone)
  {
    this.homePhone = homePhone;
    return this;
  }

  public String getOfficePhone()
  {
    return officePhone;
  }

  public ContactData setOfficePhone(String officePhone)
  {
    this.officePhone = officePhone;
    return this;
  }

  public String[] getAddress()
  {
    return address;
  }

  public ContactData setAddress(String[] address)
  {
    this.address = address;
    return this;
  }

  public String getEmail()
  {
    return email;
  }

  public ContactData setEmail(String email)
  {
    this.email = email;
    return this;
  }

  public String getAddressAsString()
  {
    if (address.length > 0)
    {
      StringBuffer addresses = new StringBuffer();
      for (String addr : address)
      {
        addresses.append(addr).append(",");
      }
      return addresses.substring(0, addresses.lastIndexOf(","));
    }
    return new String();
  }
}
