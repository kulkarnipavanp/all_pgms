
import scala.io.Source

object FileOperations {
/*
 * Program to 
 * 1. Read from file
 * 2. Convert to Map
 * 3. Store Map to class
*    
*/
	 
  def main(args:Array[String]) {

 
	val filename = "resources/data.txt"
	val getConfig = Source
			.fromFile(filename)
			.getLines()
			.map ( _ split "=")
			.collect { case Array(key, value) => (key.trim() -> value.trim()) } 
			.toMap	
	
	//val getConfig = Source.fromFile(filename).getLines().map ( _ split "=").collect { case Array(key, value) => (key.trim() -> value.trim()) }.toMap			
	
			
	val getConfig1=Map("red"->"hi","blue"->"hello")
	
	println("getConfig : " + getConfig)
	println("getConfig1 : " + getConfig1)
	
	
 	println("getConfig1 for blue : " + getConfig1("blue"))
	
 	//val passwd = getConfig.getOrElse("password", "not found")
 	println("getConfig.values : " + getConfig.values)
 	println("getConfig.keys : " + getConfig.keys)
 	
 	println("getConfig for source : " + getConfig("source"))
 	
 	println("getConfig for <password> : " + getConfig.getOrElse("password", "not found"))
 	
 	
 	
 	getConfig.keys.foreach{i=>
 		print("Key = " + i)
 		println("value = " +  getConfig(i))
 	
 		
			
	}
 	
	case class ConfigurationsModel (
 	var source : String,
 	var destination : String,
 	var username : String,
 	var password : String
 	)
 	
 	val allConfigurations = new ConfigurationsModel(getConfig("source"), getConfig("destination"),getConfig("username"), getConfig("password"))
  
	println("Source is  : " +  allConfigurations.source + "\n" +
		"Destination is  : "+ allConfigurations.destination + "\n" +   
		"Username is : " + allConfigurations.username + "\n" + 
		"Password is : " + allConfigurations.password)
	
  
  }//end of main

 	
 
	
 	
 	
	
	/*def dynamicListExtract(input: String)  = {
	    if (input contains "=") {
	      val split = input split "="
	      Some(split(0), split(1)) // return key , value
	    } else {
	      None 
	    } 
	}
	*/
	/*val getConfig1 = Map(Source.fromFile(filename).toString().split(";").flatMap ( dynamicListExtract _ ): _*)
	
	
 	println("println(getConfig1) : " + getConfig1)
 	getConfig1.foreach(println)
 	
 	
 	
 	
 	case class ConfigurationsModel (
 	var source : String,
 	var destination : String,
 	var username : String,
 	var password : String
 	)
  	
 	
 	
 	
         
         //val allConfig = ConfigurationsModel()
         //if(i.equals("source"))
       
 	
 	
 	
 	//val eachConfig = getConfig.splitAt(n)(",").groupBy(x=>x).mapValues(x=>x.length) 

  
 //val splitIt = for(i <- getConfig ) {
	 
// }  
  
  	 
  //def printList(args: TraversableOnce[_]): Unit = {
  	//args.foreach(println)
	//}
  	   
  //println(Source.fromFile("Resources/data.txt").getLines()) // returns scala.io.BufferedSource non-empty iterator instance
   
  //val s1 = Source.fromFile("Resources/data.txt").mkString; //returns the file data as String
 // println(s1)
  	
  	
  //splitting String data with white space and calculating the number of occurrence of each word in the file  
  
  //val counts = s1.split("\\s+").groupBy(x=>x).mapValues(x=>x.length) 
   
 // println(counts)
   
  //println("Count of JournalDev word:"+counts("JournalDev"))
   
  }
	
	*/
}