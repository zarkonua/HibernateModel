package drivers

import java.net.URL
import java.util
import java.util.Scanner
import com.google.gson.{JsonElement, JsonArray, JsonObject, JsonParser}
import scala.collection.JavaConversions._

object Graphite extends App {

  class Graphite {
//    val sUrl = "http://172.31.237.154/render/?width=586&height=308&_salt=1458919770.508&target=ubuntux-VirtualBox.cpu-0.cpu-idle&from=00%3A00_20160327&until=23%3A59_20160328&format=json"
    val jsonParser: JsonParser = new JsonParser
    val datapointsMap: util.HashMap[String, String] = new java.util.HashMap

//    getDatapoints(sUrl)

    def getDatapoints(url: String): util.HashMap[String, String] = {
      val v = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next()
      println(v)
      val jsonElement: JsonElement = jsonParser.parse(v)
      val jsonArray: JsonArray = jsonElement.getAsJsonArray

      println("jsonArray " + jsonArray.size())

      jsonArray.toList.foreach(v => ExtractDatapoints(v.toString))
      datapointsMap
    }

    def ExtractDatapoints(s: String): Unit = {
      if (s.contains("datapoints")) {
        val jsonObj: JsonObject = jsonParser.parse(s).getAsJsonObject
        val res = jsonObj.get("datapoints").getAsJsonArray
        println("size = " + res.size())
        println("1 = " + res.get(0).getAsJsonArray.get(0))
        for (x <- res) {
          datapointsMap.put(x.getAsJsonArray.get(1).toString, x.getAsJsonArray.get(0).toString)
        }
        //      println(res)
      } else {
        println("Error: jsonArray not contain 'datapoints'")
      }
    }
  }
}

