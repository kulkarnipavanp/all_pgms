import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EventSpringDao extends HibernateDaoSupport implements Myhiberinterface 
{
    public EventSpringDao()
	{ }
    
	public List<Event> findAll()
	{
	List<Event> lt= getHibernateTemplate().find("from Event");
	return lt;		
	}		
	public Event findRecord(Integer eid)
	{
	Event lt=(Event) getHibernateTemplate().get(Event.class,eid);	
	return lt;		
	}

	public void deleteRecord(Event obj)
	{
		getHibernateTemplate().delete(obj);		
	}
	public void addRecord(Event obj) 
	{
		getHibernateTemplate().save(obj);	
		
	}
	public void updateRecord(Event obj)
	{
	
		getHibernateTemplate().saveOrUpdate(obj);
	}
  
}
