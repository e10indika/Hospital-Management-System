package se.ucsc.hsptl.assignment.data;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Pathum on 5/2/2017.
 */
public class NameTest
{
  private Name name;

  @BeforeMethod
  public void setUp() throws Exception
  {
    name = new Name("indika", "saman", "kumara", "Mr");
  }

  @Test
  public void testGetFormattedName() throws Exception
  {
    Assert.assertEquals(name.getFormattedName(), "indika saman kumara");
  }

  @Test
  public void testGetPresentationName() throws Exception
  {
    Assert.assertEquals(name.getPresentationName(), "Mr KUMARA I. S.");
  }

}