package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    goToGroupPage();
    selectGroup();
    wd.findElement(By.name("delete")).click();
    wd.findElement(By.linkText("group page")).click();
  }

  private void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }


}
