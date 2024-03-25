package productProject;

public class Clientclass 
{

	public static void main(String[] args) 
	{
		ProductDao productDao=new ProductDao();
		int count=productDao.createProductTable();
		System.out.println("table is created successfully..."+count);

	}

}
