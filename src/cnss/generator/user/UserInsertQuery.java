//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
package cnss.generator.user;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @since Mar 17, 2014
 * @author zyu
 */
public class UserInsertQuery
{

  /**
   *
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException
  {
    FileOutputStream out = new FileOutputStream("D:\\temp\\userupdate\\UserUpdateQuery.txt");
    for (int i = 1; i <= 126; i++)
    {

      String wall = "W" + String.format("%03d", i);
      StringBuilder sb = new StringBuilder();
      sb.append("INSERT INTO inther_lc.ilc_person(\n"
              + "            id, logical_id, name, shortname, lastname, description, country_id, \n"
              + "            language_id, variant_id, gendate, moddate, genuser_id, moduser_id, \n"
              + "            eversion)\n"
              + "    VALUES ('")
              .append(wall).append("', '").append(wall)
              .append("', 'TEST', 'TEST', 'TEST', NULL, 'CN', \n"
                      + "            'zh', 'PTL', null, null, null, null, \n"
                      + "            0); \n");
      sb.append("INSERT INTO inther_lc.ilc_person_user(\n"
              + "            id, usergroup_id, hashpassword, enabled, deleted)\n"
              + "    VALUES ('")
              .append(wall)
              .append("', 2, 'b86b72cd0adb02808c107974f69f19ece98f26384095d35f46722935ba64a254e45986247732c03c', 't', null);\n\n");
      out.write(sb.toString().getBytes());
    }
  }
}
