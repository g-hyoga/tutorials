object PassStudents {

  def haveEnglishAndMath(m: Map[String, Int]): Boolean = {
    m.isDefinedAt("math") && m.isDefinedAt("english")
  }

  def passStudents(scores: Map[String, Map[String, Int]]): Map[String, Int] = {
    scores.filter{ case (_, score) =>
      haveEnglishAndMath(score) && (score("math") + score("english")) / 2 >= 80
      }.map{ case (name, score) =>
        name -> (score("math") + score("english")) / 2
      }
  }

  def passStudents2(scores: Map[String, Map[String, Int]]): Map[String, Int] = {
    scores.flatMap{ case (name, score) =>
      if (haveEnglishAndMath(score)) Some(name -> score) else None
      }.flatMap { case (name, score) =>
        if ((score("math") + score("english")) / 2 >= 80){
          Some(name -> score)
        } else {
          None
        }
        }.flatMap{ case (name, score) =>
          Map(name -> (score("math") + score("english")) / 2)
        }
  }

  def passStudents3(scores: Map[String, Map[String, Int]]): Map[String, Int]= {
    scores.collect { case (name, score)
      if score.isDefinedAt("math") && score.isDefinedAt("english")
      && (score("math") + score("english")) / 2 >= 80 =>
        name -> (score("math") + score("english")) / 2
    }.toMap
  }

  def passStudents4(scores: Map[String, Map[String, Int]]): Unit = {
    for {
      score <- scores
      if haveEnglishAndMath(score._2); if (score._2("english") + score._2("math") / 2) >= 80
      } yield {
        println(score)
      }
  }

  def main(args: Array[String]): Unit = {
    val scores = Map(
      "ichiro" -> Map("math"->82, "english"->99),
      "jiro" -> Map("japanese"->100, "social"->88),
      "saburo" -> Map("math"->76, "english"->80),
      "shiro" -> Map("math"->99, "social"->81),
      "hanako" -> Map("math"->84, "english"->78, "social"->66))

    //println(passStudents(scores))
    //println(passStudents2(scores))
    //println(passStudents3(scores))
    println(passStudents4(scores))
  }
}


