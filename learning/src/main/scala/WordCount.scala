
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext._


object WordCount {

  def main(args: Array[String]): Unit = {

    val inputfile="/sparkinput"
    val conf=new SparkConf().setAppName("WordCount").setMaster("local[2]")
    val sc=new SparkContext(conf)
    val textfile=sc.textFile(inputfile)
    val data=textfile.flatMap(a=>a.split(" ")).map(b=>(b,1)).reduceByKey((c1,c2)=>c1+c2)
    data.foreach(println)

    //collect返回所有partitions的结果，结果形式为一个数组。
    data.collect()

    data.foreach(a=>print(a))


  }


}
