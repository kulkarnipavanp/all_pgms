import java.util.List;


public interface Myhiberinterface 
{
	public List findAll();
	public void deleteRecord(Event obj);
	public void addRecord(Event obj);
	public void updateRecord(Event obj);	
	Event findRecord(Integer k);
}
