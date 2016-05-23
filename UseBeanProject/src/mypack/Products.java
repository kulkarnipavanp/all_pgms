package mypack;
public class Products 
{
private int pid,cost,qty;
private String name;
public Products() 
{
	pid=0;
	cost=0;
	qty=0;
	name="";
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
