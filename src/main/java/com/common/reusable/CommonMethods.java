package com.common.reusable;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class CommonMethods {

	public static Recordset getExcelData(String strQuery,String strFilePath)
	{
		Recordset recordset = null;
		Connection connection =null;
		try {

			Fillo fcon  = new Fillo();
			connection=fcon.getConnection(strFilePath);
			recordset=connection.executeQuery(strQuery);

		} catch (FilloException e) {
			e.printStackTrace();
		}
		finally
		{
			connection.close();
		}
		return recordset;
	}

	/* Method to check whether the provided userName and password is valid */
	/* Also if the userName is valid Fetch the Role of user from data scource*/

	public static String loginValidator(String struser,String strPassword)
	{
		String result= " ";
		String path = System.getProperty("user.dir")+"\\config.xlsx";
		String query = "Select * from UserMaintenance";
		
		try {
			Recordset rs = getExcelData(query,path);
			while(rs.next())
			{
				if (rs.getField("UserName").equals(struser) && rs.getField("Password").equals(strPassword))
				{
					result = rs.getField("Role");
					break;
				}
				/*else if (!rs.getField("UserName").equals(struser))
				{
					result = "Error: Invalid User Name - Please check the User Name";
				}*/
				else if (rs.getField("UserName").equals(struser) && !rs.getField("Password").equals(strPassword))
				{
					result = "Error: Password wrong - Please provide the valid password";
				}
				else
				{
					result = "Error: Invalid Credential";
				}
				
			}
		} catch (Exception e) {
			
			result = "Error: Invalid Credential";
		}

		return result;
	}



}
