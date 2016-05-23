import java.util.Date;
public class Event 
{
    private Integer id;
    private int duration;
    private String name;
    private Date startDate;

    public Event()
	{ }

    public Event(String name) 
	{
        this.name = name;
    }   
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name;   }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}