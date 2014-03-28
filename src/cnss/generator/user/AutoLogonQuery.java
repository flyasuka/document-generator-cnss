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
 * @since Mar 27, 2014
 * @author zyu
 */
public class AutoLogonQuery
{

  /**
   *
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException
  {
    FileOutputStream out = new FileOutputStream("D:\\temp\\AutoLogonQuery.txt");
    for (int i = 1; i <= 126; i++)
    {
      String wall = "W" + String.format("%03d", i);
      StringBuilder sb = new StringBuilder();

      sb.append("INSERT INTO inther_lc.ilc_usersession(\n"
              + "            inth_type, id, user_id, hostname, genuser_id, moduser_id, module_id, \n"
              + "            gendate, moddate, eversion)\n");
      sb.append("    VALUES ('UserSessionCore', '").append(wall).append("', '").append(wall).append("', '").append("', null, null, 'inther-terminal-ptl',\n");
      sb.append("            null, null, 0);\n\n");
      out.write(sb.toString().getBytes());
    }
    for (int i = 1; i <= 126; i++)
    {
      String wall = "W" + String.format("%03d", i);
      StringBuilder sb = new StringBuilder();
      sb.append("UPDATE inther_lc.wkf_session set moduser_id = '").append(wall).append("', ").append("contextdata = 593500").append(" where id = '").append(wall).append("';\n\n");
      out.write(sb.toString().getBytes());
    }
  }

}
