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

  public String getHomePhone()
  {
    return homePhone;
  }

  public String getOfficePhone()
  {
    return officePhone;
  }

  public String[] getAddress()
  {
    return address;
  }

  public String getEmail()
  {
    return email;
  }
}
