package package1;

import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.conf.Configuration;
import java.io.*;

public class HBaseDDL {
	
  public static void main(String[]args) throws IOException{
	  Configuration config = HBaseConfiguration.create();
	  Connection conn = ConnectionFactory.createConnection(config);
      Admin hAdmin = conn.getAdmin();
      //Object of the HTableDescriptor 
	  HTableDescriptor des = new HTableDescriptor(TableName.valueOf("emp"));
	  des.addFamily(new HColumnDescriptor("personel"));
	  des.addFamily(new HColumnDescriptor("professional"));
	  
	  if(hAdmin.tableExists(TableName.valueOf("emp"))) {
		  System.out.println("Table already exists");
	  }
	  else {
		  hAdmin.createTable(des);
		  System.out.println("Table created");
	  }
  }
  
}
