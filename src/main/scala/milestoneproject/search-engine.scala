// src/main/scala/milestoneproject/search-engine.scala
package milestoneproject

object searchEngine {
  /******************************************************
  **             Search Engine Classes
  ******************************************************/
  class User(userName: String, pass: String, history: List[Search]) {
    val name = userName
    private val password = pass
    val searchHistory = history

    override def toString: String = {
      return s"${userName}'s Search History\n$searchHistory"
    }
  }

  case class Search(value: String, results: List[Result])

  case class Result(title: String, description: String)

  def userFrequentSearch(usr: User): String = {
    @scala.annotation.tailrec
    def groupSearches(searches: List[Search], groups: List[List[Search]]): List[List[Search]] =
      searches match {
        case Nil          => groups
        case head :: tail =>
          val p = searches.partition(_ == head)
          groupSearches(p._2, groups :+ p._1)
    }
    val frequencies = groupSearches(usr.searchHistory, Nil)

    if (frequencies.isEmpty) {
      return "No Search History Found"
    } else {
      return frequencies.maxBy(_.length).head.value
    }
  }

  def engineFrequentSearch(users: List[User]): String = {
    @scala.annotation.tailrec
    def groupSearches(searches: List[Search], groups: List[List[Search]]): List[List[Search]] =
      searches match {
        case Nil          => groups
        case head :: tail =>
          val p = searches.partition(_ == head)
          groupSearches(p._2, groups :+ p._1)
    }
    val engineHistory = (for (usr <- users) yield usr.searchHistory).flatten
    val frequencies = groupSearches(engineHistory, Nil)

    if (frequencies.isEmpty) {
      return "No Search History Found"
    } else {
      return frequencies.maxBy(_.length).head.value
    }
  }

  /******************************************************
  **                      MAIN
  ******************************************************/
  def main(args: Array[String]) {
    // Make some searches and fill them with results
    val weatherSearch = Search("Weather", List(
      Result("Springfield's Weather", "Local weather report for your area."),
      Result("National Weather Report", "Your up to date location for weather around the world."))
    )

    val catVideoSearch = Search("Cat Videos", List(
      Result("Cat Fights Off Bear", "This little cat thinks it's king of the jungle!"),
      Result("Nyan Cat Needs to Stop", "\"It was never funny. It's still not funny\" ~everyone"),
      Result("Cat Videos United", "Just a website to host cat vidoes and nothing else. You're welcome."))
    )

    val cardinalsSearch = Search("Cardinals", List(
      Result("Cardinals Nation", "You're one stop for up to date Cardinal's score and news"),
      Result("MLB Network", "Cardinals vs. Orioles: Live Score Updates"))
    )

    val pieSearch = Search("pie", List(
      Result("Apple Pie Recipe", "Famous homemade apple pie recipe"),
      Result("Pie Eating Contest", "United Way is hosting a pie eating contest as a fund raiser"),
      Result("Dave's Deli", "Freshly made pies, muffins, donuts...."))
    )

    val badSearch = Search("asdfffffff", List())

    // Create some users
    val Keith = new User("Keith", "StrongPassWord", List(cardinalsSearch, weatherSearch, cardinalsSearch, cardinalsSearch))
    val Connor = new User("Connor", "SecretPhrase", List(weatherSearch, catVideoSearch, badSearch, catVideoSearch))
    val Curly = new User("Curly", "Password123", List())
    val Moe = new User("Moe", "Wordpass321", List(pieSearch))
    val Larry = new User("Larry", "NyakNyakNyak", List(pieSearch, weatherSearch))
    val Tessa = new User("Tessa", "Bookw0rm", List(weatherSearch, pieSearch, weatherSearch))
    val Patrick = new User("Pat", "123456", List(cardinalsSearch, badSearch, cardinalsSearch, weatherSearch))
    val Lewis = new User("LewCustom", "K7L", List(weatherSearch, pieSearch, cardinalsSearch))
    val Tommy = new User("TomCatBolls", "art4life", List(badSearch, weatherSearch, weatherSearch))
    val Mark = new User("Mark", "riffraff", List(cardinalsSearch, weatherSearch, pieSearch))

    // Create a list of all the users
    val searchEngineUsers = List(Keith, Connor, Curly, Moe, Larry, Tessa, Patrick, Lewis, Tommy, Mark)

    // Print out info on all the users
    //for (user <- searchEngineUsers) println(user)

    // Find each user's most frequent search
    for (user <- searchEngineUsers) println(s"${user.name}'s most frequent search: ${userFrequentSearch(user)}")

    // Find the most frequent search on the engine
    println(s"Most frequent search on this engine: ${engineFrequentSearch(searchEngineUsers)}")
  }
}
